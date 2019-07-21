package io.gunmarket.demo.product.domain.product;

import io.gunmarket.demo.product.domain.Brand;
import io.gunmarket.demo.product.domain.Caliber;
import io.gunmarket.demo.product.domain.ProductInShop;
import io.gunmarket.demo.product.domain.Type;
import io.gunmarket.demo.product.domain.WeaponPlatform;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

import static io.gunmarket.demo.product.domain.Brand.BRAND_ID;
import static io.gunmarket.demo.product.domain.Caliber.CALIBER_ID;
import static io.gunmarket.demo.product.domain.Type.TYPE_ID;
import static io.gunmarket.demo.product.domain.WeaponPlatform.WEAPON_PLATFORM_ID;
import static io.gunmarket.demo.product.domain.product.Product.PRODUCT_TABLE;


@Entity
@Table(name = PRODUCT_TABLE)
@Getter
@Setter
@ToString
public abstract class Product {
	public static final String PRODUCT_TABLE = "product";
	public static final String PRODUCT_AVG_PRICE = "averagePrice";
	public static final String PRODUCT_MODEL = "model";
	public static final String PRODUCT_ID = "product_id";
	public static final String PRODUCT_WEIGHT = "weight";
	public static final String PRODUCT_DTYPE = "dtype";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = PRODUCT_ID, length = 8, nullable = false)
	private Long productId;

	@Column(name = PRODUCT_AVG_PRICE)
	private double averagePrice;

	@Column(name = PRODUCT_MODEL)
	private String model;

	@Column(name = PRODUCT_WEIGHT)
	private String weight;

	@ManyToOne
	@JoinColumn(name = BRAND_ID, nullable = false)
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = TYPE_ID, nullable = false)
	private Type type;

	@ManyToOne
	@JoinColumn(name = CALIBER_ID)
	private Caliber caliber;

	@ManyToOne
	@JoinColumn(name = WEAPON_PLATFORM_ID)
	private WeaponPlatform weaponPlatform;

	@OneToMany(mappedBy = PRODUCT_TABLE)
	private Set<ProductInShop> productInShops;
}
