package io.gunmarket.demo.dbUpdater.brand.techkrim;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;


@Component
public class TechKrimParser {
	private static final String url = "http://techcrim.ru/";



	public static void main(String[] args) {
		Jsoup.connect(url);
	}
}
