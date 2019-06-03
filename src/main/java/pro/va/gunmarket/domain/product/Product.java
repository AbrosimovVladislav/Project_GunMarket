package pro.va.gunmarket.domain.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;
import pro.va.gunmarket.domain.Brand;
import pro.va.gunmarket.domain.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static pro.va.gunmarket.domain.Brand.BRAND_ID;
import static pro.va.gunmarket.domain.Type.TYPE_ID;
import static pro.va.gunmarket.domain.product.Product.PRODUCT_TABLE;

@Entity
@Table(name = PRODUCT_TABLE)
@Component
@Getter
@Setter
@ToString
public abstract class Product {

	public static final String PRODUCT_TABLE = "brand";

	public static final String PRODUCT_AVG_PRICE = "averagePrice";

	public static final String PRODUCT_MODEL = "model";

	public static final String PRODUCT_ID = "id";

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = PRODUCT_ID, length = 8, nullable = false)
	private Long id;

	@Column(name = PRODUCT_AVG_PRICE)
	private double averagePrice;

	@Column(name = PRODUCT_MODEL)
	private String model;

	@ManyToOne
	@JoinColumn(name = BRAND_ID, nullable = false)
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = TYPE_ID, nullable = false)
	private Type type;
}
