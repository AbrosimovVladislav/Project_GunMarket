package io.gunmarket.demo.dbUpdater.shop.armsline;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ArmsLineParser {

	private static final String postfix = "?&from=";
	private static final int pageSize = 20;

	//ToDo Сделать патроны для допарсинга
	List<ArmsLineProduct> getProductsFromCategory(String categoryUrl, String categoryName) {
		int totalQuantityProducts = getQuantityOfCategory(categoryUrl);
		return Stream.iterate(0, current -> current + pageSize)
				.limit(totalQuantityProducts / pageSize)
				.map(offset -> categoryUrl + postfix + offset)
				.map(resultCategoryUrl -> parseArmsLinePage(resultCategoryUrl, categoryName))
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
	}

	private int getQuantityOfCategory(String categoryUrl) {
		Document doc;
		try {
			doc = Jsoup.connect(categoryUrl).get();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		Elements aElementsInPagenavi = doc.body().getElementsByClass("pagenavi").select("a");
		if (aElementsInPagenavi.size() == 0) return 0;
		String hrefVal = aElementsInPagenavi.get(aElementsInPagenavi.size() - 2).attr("href");
		return Integer.valueOf(hrefVal.substring(hrefVal.indexOf('=') + 1));
	}

	private List<ArmsLineProduct> parseArmsLinePage(String pageUrl, String categoryName) {
		Document doc;
		try {
			doc = Jsoup.connect(pageUrl).get();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		return doc.body().getElementsByClass("marketApp").stream().map(element -> {
			String name = element.select("a").text();
			String link = element.select("a").attr("href");
			String price = element.select("strong").text();
			String inStock = element.select("span").text();
			return new ArmsLineProduct(name, link, price, inStock, categoryName);
		}).peek(System.out::println).collect(Collectors.toList());
	}

}