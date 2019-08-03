package io.gunmarket.demo.dbUpdater.shop.armsline;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
@EqualsAndHashCode
public class ArmsLineProduct {

	public final static String shopName = "ArmsLine";

	private final String category;

	private final String name;

	private final String link;

	private final double price;

	private final double salePrice;

	private final boolean inStock;

	// TODO: extract logic from constructor
	public ArmsLineProduct(String name, String link, String price, String inStock, String category) {
		this.category = category;
		this.name = name;
		this.link = link;
		String preparedPriceString = price.replaceAll("[^0-9,]", "").replaceAll(",", ".");
		if (preparedPriceString.isBlank()) {
			this.price = 0;
			this.salePrice = this.price;
		} else if (StringUtils.countOccurrencesOf(preparedPriceString, ".") == 2) {
			int dotIndexPlusTwo = preparedPriceString.indexOf('.') + 2;
			this.price = Double.valueOf(preparedPriceString.substring(0, dotIndexPlusTwo));
			this.salePrice = Double.valueOf(preparedPriceString.substring(dotIndexPlusTwo));
		} else {
			this.price = Double.valueOf(preparedPriceString);
			this.salePrice = this.price;
		}
		this.inStock = "есть".equalsIgnoreCase(inStock);
	}

}
