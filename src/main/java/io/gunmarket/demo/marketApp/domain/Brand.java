package io.gunmarket.demo.marketApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gunmarket.demo.marketApp.domain.product.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

import static io.gunmarket.demo.marketApp.domain.Brand.BRAND_TABLE;


@Entity
@Table(name = BRAND_TABLE)
@Getter
@Setter
@ToString(exclude = {"products"})
@EqualsAndHashCode
public class Brand {
	public static final String BRAND_TABLE = "brand";
	public static final String BRAND_ID = "brand_id";
	public static final String BRAND_SHORT_NAME = "shortName";
	public static final String BRAND_FULL_NAME = "fullName";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = BRAND_ID, length = 8, nullable = false)
	private Long brandId;

	@Column(name = BRAND_SHORT_NAME)
	private String shortName;

	@Column(name = BRAND_FULL_NAME)
	private String fullName;

	@JsonIgnore
	@OneToMany(mappedBy = BRAND_TABLE)
	private Set<Product> products;
}
