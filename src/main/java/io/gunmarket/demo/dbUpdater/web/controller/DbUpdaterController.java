package io.gunmarket.demo.dbUpdater.web.controller;

import io.gunmarket.demo.dbUpdater.shop.armsline.ArmsLineParser;
import io.gunmarket.demo.product.domain.ProductInShop;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DbUpdaterController {
	private final ArmsLineParser armsLineParser;

	public DbUpdaterController(ArmsLineParser armsLineParser) {
		this.armsLineParser = armsLineParser;
	}

	@GetMapping(value = "/updateProductInShop/{parserName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ProductInShop> updateByParserName(@PathVariable String parserName) {
		return armsLineParser.updateArmsLineContent();
	}
}
