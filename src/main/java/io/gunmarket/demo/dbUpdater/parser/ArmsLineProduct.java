package io.gunmarket.demo.dbUpdater.parser;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class ArmsLineProduct {

	final String category;

	final String name;

	final String link;

	final String price;

	final boolean inStock;

	public ArmsLineProduct(String name, String link, String price, String inStock, String category) {
		this.category = category;
		this.name = name;
		this.link = link;
		this.price = price;
		this.inStock = "есть".equalsIgnoreCase(inStock);
	}

}
