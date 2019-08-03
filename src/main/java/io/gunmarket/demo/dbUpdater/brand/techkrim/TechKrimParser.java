package io.gunmarket.demo.dbUpdater.brand.techkrim;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TechKrimParser {
	private static final String TECHCRIM_MAIN_PAGE = "http://techcrim.ru/";
	private static final String GAZOVII_BALONCHIKI = TECHCRIM_MAIN_PAGE + "?page_id=131";
	private static final String PATRONY_DROB = TECHCRIM_MAIN_PAGE + "?page_id=339";

	public static void main(String[] args) {
		Document document = getDocumentByUrl(PATRONY_DROB);
		List<String> productLinks = document.body()
				.select("tr")
				.stream()
				.skip(2)
				.map(element -> element.select("a").attr("href"))
				.filter(e -> !e.isEmpty())
				.collect(Collectors.toList());

		productLinks.stream()
				.map(TechKrimParser::getDocumentByUrl)
				.map(doc -> {
					Elements element = doc.getElementsByClass("entry-content");
//					String desc = element.select("p");

					String imageLink = element.select("a").attr("href");

//					return desc;
					return null;
//					return   new TechKrimProduct();
				})
				.peek(System.out::println)
				.collect(Collectors.toList());
	}

	private static List<Object> parseGazoviiBalonchiki() {
		Document document = getDocumentByUrl(GAZOVII_BALONCHIKI);
		assert document != null;
		List<String> productLinks = document.body()
				.getElementsByClass("entry-content")
				.stream()
				.flatMap(element -> element.select("li")
						.stream()
						.map(li -> li.select("a").attr("href"))
				)
				.filter(link -> !link.isBlank())
				.collect(Collectors.toList());
		return productLinks.stream()
				.map(TechKrimParser::getDocumentByUrl)
				.filter(Objects::nonNull)
//				.peek(doc -> doc.body().select(""))
				.peek(System.out::println)
				.collect(Collectors.toList());
	}

	private static Document getDocumentByUrl(String pageUrl) {
		try {
			return Jsoup.connect(pageUrl).get();
		} catch (HttpStatusException statusEx) {
			return null;
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
