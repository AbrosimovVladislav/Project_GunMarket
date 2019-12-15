package io.gunmarket.demo.marketApp.repo.dslbuilder;

import io.gunmarket.demo.marketApp.domain.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class DslBuilderTest {
	private static final DslBuilder dslBuilder = new DslBuilder();

	@Test
	void build() {
		var map = Map.of(
				"dtype", "gun",
				"price","5000interval10000",
				"shop.address", "address1",
				"brand.shortName", "brand-name1,brand-name2",
				"caliber.caliberValue","caliber-value1"
		);

		Assertions.assertEquals(
			"dtype=gun&"
					+ "price=5000interval10000&"
					+ "shop.address=address1&"
					+ "brand.shortName=brand-name1,brand-name2&"
					+ "caliber.caliberValue=caliber-value1",
			dslBuilder.build(map, Product.class)
		);
	}
}