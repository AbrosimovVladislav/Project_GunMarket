package io.gunmarket.demo.dbUpdater.kadastr.gost;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GostParser {

	public static final String GOST_START_PAGE = "https://www.gost.ru/portal/gost/home/systems/weapons/cad";

	List<GostProduct> getGostProducts() {
		List<GostProduct> gostProducts = new ArrayList<>();
		String currentPageUrl = GOST_START_PAGE;
		Element docBody;

		do {
			Document doc;
			try {
				doc = Jsoup.connect(currentPageUrl).get();
			} catch (IOException e) {
				throw new UncheckedIOException(e);
			}

			docBody = doc.body();

			gostProducts.addAll(docBody.getElementsByClass("gost-table standards-table")
					.select("tbody")
					.select("tr")
					.stream()
					.map(tr -> {
						Elements tds = tr.select("td");
						String internalId = tds.first().text();
						String name = tds.next().first().text();
						String brand = tds.next().next().first().text();
						String technicalIndicators = tds.next().next().next().next().first().text();
						return new GostProduct(internalId, name, brand, technicalIndicators);
					})
					.collect(Collectors.toList()));

			currentPageUrl = docBody.getElementsByClass("gost-paging").select("a").next().attr("href");
		}
		while (!isLastPage(docBody));

		return gostProducts;
	}

	boolean isLastPage(Element docBody) {
		String[] pageNumbersInfo =
				docBody.getElementsByClass("gost-paging__count").text().replaceAll("[a-zA-z]", "").split(" ");
		return Arrays.stream(pageNumbersInfo)
				.map(String::trim)
				.filter(e -> !e.isEmpty())
				.map(Integer::valueOf)
				.collect(Collectors.toSet())
				.size() == 1;
	}

}

