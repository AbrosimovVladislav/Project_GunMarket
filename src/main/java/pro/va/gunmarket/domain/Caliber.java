package pro.va.gunmarket.domain;

import lombok.Getter;
import lombok.Setter;
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

import static pro.va.gunmarket.domain.Caliber.CALIBER_TABLE;


@Entity
@Component
@Table(name = CALIBER_TABLE)
@Getter
@Setter
public class Caliber {
	public static final String CALIBER_TABLE = "caliber";
	public static final String CALIBER_ID = "caliberId";
	public static final String CALIBER_VALUE = "value";

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = CALIBER_ID, length = 8, nullable = false)
	private Long caliberId;

	@Column(name = CALIBER_VALUE)
	private String value;

	@OneToMany(mappedBy = CALIBER_TABLE)
	Set<Product> products;

	public Caliber() {
	}

	public Caliber(String value) {
		this.value = value;
	}
}
