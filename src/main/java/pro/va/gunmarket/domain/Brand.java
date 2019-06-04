package pro.va.gunmarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;
import pro.va.gunmarket.domain.product.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

import static pro.va.gunmarket.domain.Brand.BRAND_TABLE;


@Entity
@Table(name = BRAND_TABLE)
@Component
@Getter
@Setter
public class Brand {

	public static final String BRAND_TABLE = "brand";

	public static final String BRAND_ID = "id";

	public static final String BRAND_NAME = "name";

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = BRAND_ID, length = 8, nullable = false)
	private Long id;

	@Column(name = BRAND_NAME)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = BRAND_TABLE)
	private Set<Product> products;

	public Brand(String name, Set<Product> products) {
		this.name = name;
		this.products = products;
	}
}
