package pro.va.gunmarket.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pro.va.gunmarket.domain.product.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static pro.va.gunmarket.domain.ProductInShop.PRODUCT_IN_SHOP_TABLE;
import static pro.va.gunmarket.domain.Shop.SHOP_ID;
import static pro.va.gunmarket.domain.product.Product.PRODUCT_ID;


@Entity
@Component
@Table(name = PRODUCT_IN_SHOP_TABLE)
@Getter
@Setter
public class ProductInShop {
	public static final String PRODUCT_IN_SHOP_TABLE = "productInShop";
	public static final String PRODUCT_IN_SHOP_PRICE = "price";
	public static final String PRODUCT_IN_SHOP_SALE = "sale";
	public static final String PRODUCT_IN_SHOP_IN_STOCK = "inStock";
	public static final String PRODUCT_IN_SHOP_ADDITIONAL_INFO = "additionalInfo";
	public static final String PRODUCT_IN_SHOP_LINK = "link";

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
