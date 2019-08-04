package io.gunmarket.demo.marketApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.gunmarket.demo.marketApp.domain.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static io.gunmarket.demo.marketApp.domain.ProductInShop.PRODUCT_IN_SHOP_TABLE;
import static io.gunmarket.demo.marketApp.domain.Shop.SHOP_ID;
import static io.gunmarket.demo.marketApp.domain.product.Product.PRODUCT_ID;

@Entity
@Table(name = PRODUCT_IN_SHOP_TABLE)
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"product"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductInShop {
	public static final String PRODUCT_IN_SHOP_ID = "productInShopId";
	public static final String PRODUCT_IN_SHOP_TABLE = "productInShop";
	public static final String PRODUCT_IN_SHOP_PRICE = "price";
	public static final String PRODUCT_IN_SHOP_SALE = "sale";
	public static final String PRODUCT_IN_SHOP_IN_STOCK = "inStock";
	public static final String PRODUCT_IN_SHOP_ADDITIONAL_INFO = "additionalInfo";
	public static final String PRODUCT_IN_SHOP_LINK = "link";

	@Id
	@Column(name = PRODUCT_IN_SHOP_ID, nullable = false)
	private String productInShopId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = PRODUCT_ID, nullable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = SHOP_ID, nullable = false)
	private Shop shop;

	@Column(name = PRODUCT_IN_SHOP_PRICE, nullable = false)
	private double price;

	//ToDO выставить ограничение по скидке
	@Column(name = PRODUCT_IN_SHOP_SALE)
	private int sale;

	@Column(name = PRODUCT_IN_SHOP_IN_STOCK, nullable = false)
	private boolean inStock;

	@Column(name = PRODUCT_IN_SHOP_ADDITIONAL_INFO)
	private String additionalInfo;

	@Column(name = PRODUCT_IN_SHOP_LINK, nullable = false)
	private String link;

	public ProductInShop(Product product, Shop shop, double price, boolean inStock, String link, int sale) {
		this.productInShopId = product.getProductId() + ":" + shop.getShopId();
		this.product = product;
		this.shop = shop;
		this.price = price;
		this.inStock = inStock;
		this.link = link;
		this.sale = sale;
	}
}
