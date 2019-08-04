package io.gunmarket.demo.dbUpdater.web.controller;

import io.gunmarket.demo.dbUpdater.kadastr.gost.GostUpdater;
import io.gunmarket.demo.dbUpdater.shop.armsline.ArmsLineUpdater;
import io.gunmarket.demo.marketApp.domain.ProductInShop;
import io.gunmarket.demo.marketApp.domain.product.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DbUpdaterController {
	private final ArmsLineUpdater armsLineUpdater;
	private final GostUpdater gostUpdater;

	public DbUpdaterController(ArmsLineUpdater armsLineUpdater, GostUpdater gostUpdater) {
		this.armsLineUpdater = armsLineUpdater;
		this.gostUpdater = gostUpdater;
	}

	@GetMapping(value = "/updateProductInShop/{parserName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ProductInShop> updateByParserName(@PathVariable String parserName) {
		return armsLineUpdater.updateArmsLineContent();
	}

	@GetMapping(value = "/updateProduct", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Product> updateProducts() {
		return gostUpdater.updateGostContent();
	}
}
