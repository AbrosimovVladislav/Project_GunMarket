package pro.va.gunmarket.domain;

import lombok.Getter;
import lombok.Setter;
import pro.va.gunmarket.domain.product.Product;


@Getter
@Setter
public class ProductInShop {
	private Product product;
	private Shop shop;
	private double price;
	private int sale;
	private boolean inStock;
	private String additionalInfo;
	private String link;

	public ProductInShop(Product product, Shop shop, double price, boolean inStock, String link) {
		this.product = product;
		this.shop = shop;
		this.price = price;
		this.inStock = inStock;
		this.link = link;
	}

	public ProductInShop(Product product,
			Shop shop,
			double price,
			int sale,
			boolean inStock,
			String additionalInfo,
			String link) {
		this.product = product;
		this.shop = shop;
		this.price = price;
		this.sale = sale;
		this.inStock = inStock;
		this.additionalInfo = additionalInfo;
		this.link = link;
	}
}
