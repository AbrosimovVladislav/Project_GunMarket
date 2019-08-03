package io.gunmarket.demo.dbUpdater.web.controller;

import io.gunmarket.demo.dbUpdater.shop.armsline.ArmsLineUpdater;
import io.gunmarket.demo.marketApp.domain.ProductInShop;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DbUpdaterController {
	private final ArmsLineUpdater armsLineUpdater;

	public DbUpdaterController(ArmsLineUpdater armsLineUpdater) {
		this.armsLineUpdater = armsLineUpdater;
	}

	@GetMapping(value = "/updateProductInShop/{parserName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ProductInShop> updateByParserName(@PathVariable String parserName) {
		return armsLineUpdater.updateArmsLineContent();
	}
}
