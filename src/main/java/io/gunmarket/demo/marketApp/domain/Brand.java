package io.gunmarket.demo.marketApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gunmarket.demo.marketApp.domain.product.Product;
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
public class Brand {
	public static final String BRAND_TABLE = "brand";
	public static final String BRAND_ID = "brand_id";
	public static final String BRAND_NAME = "name";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = BRAND_ID, length = 8, nullable = false)
	private Long brandId;

	@Column(name = BRAND_NAME)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = BRAND_TABLE)
	private Set<Product> products;
}
