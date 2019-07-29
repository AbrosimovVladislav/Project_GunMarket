package io.gunmarket.demo.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.gunmarket.demo.product.domain.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static io.gunmarket.demo.product.domain.ProductInShop.PRODUCT_IN_SHOP_TABLE;
import static io.gunmarket.demo.product.domain.Shop.SHOP_ID;
import static io.gunmarket.demo.product.domain.product.Product.PRODUCT_ID;

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

	public ProductInShop(Product product, Shop shop, double price, boolean inStock, String link, int sale) {
		this.product = product;
		this.shop = shop;
		this.price = price;
		this.inStock = inStock;
		this.link = link;
		this.sale = sale;
	}

}
