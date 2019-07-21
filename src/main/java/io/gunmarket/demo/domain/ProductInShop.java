package io.gunmarket.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gunmarket.demo.domain.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static io.gunmarket.demo.domain.ProductInShop.PRODUCT_IN_SHOP_TABLE;
import static io.gunmarket.demo.domain.Shop.SHOP_ID;
import static io.gunmarket.demo.domain.product.Product.PRODUCT_ID;


@Entity
@Table(name = PRODUCT_IN_SHOP_TABLE)
@Getter
@Setter
public class ProductInShop {
	public static final String PRODUCT_IN_SHOP_ID = "productInShopId";
	public static final String PRODUCT_IN_SHOP_TABLE = "productInShop";
	public static final String PRODUCT_IN_SHOP_PRICE = "price";
	public static final String PRODUCT_IN_SHOP_SALE = "sale";
	public static final String PRODUCT_IN_SHOP_IN_STOCK = "inStock";
	public static final String PRODUCT_IN_SHOP_ADDITIONAL_INFO = "additionalInfo";
	public static final String PRODUCT_IN_SHOP_LINK = "link";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = PRODUCT_IN_SHOP_ID, length = 8, nullable = false)
	private Long productInShopId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = PRODUCT_ID, nullable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = SHOP_ID, nullable = false)
	private Shop shop;

	@Column(name = PRODUCT_IN_SHOP_PRICE, nullable = false)
	private double price;

	@Column(name = PRODUCT_IN_SHOP_SALE)
	private int sale;

	@Column(name = PRODUCT_IN_SHOP_IN_STOCK, nullable = false)
	private boolean inStock;

	@Column(name = PRODUCT_IN_SHOP_ADDITIONAL_INFO)
	private String additionalInfo;

	@Column(name = PRODUCT_IN_SHOP_LINK, nullable = false)
	private String link;

	public ProductInShop() {
	}

	public ProductInShop(Product product, Shop shop, double price, boolean inStock, String link) {
		this.product = product;
		this.shop = shop;
		this.price = price;
		this.inStock = inStock;
		this.link = link;
	}

	public ProductInShop(
			Product product,
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
