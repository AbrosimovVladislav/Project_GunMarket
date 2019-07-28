package io.gunmarket.demo.dbUpdater.parser;

import lombok.ToString;

import java.util.Objects;

@ToString
public class ArmsLineProduct {
	final String name;
	final String link;
	final String price;
	final boolean inStock;

	public ArmsLineProduct(String name, String link, String price, String inStock) {
		this.name = name;
		this.link = link;
		this.price = price;
		this.inStock = "есть".equalsIgnoreCase(inStock);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArmsLineProduct that = (ArmsLineProduct) o;
		return inStock == that.inStock && Objects.equals(name, that.name) && Objects.equals(link, that.link) &&
				Objects.equals(price, that.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, link, price, inStock);
	}

}
