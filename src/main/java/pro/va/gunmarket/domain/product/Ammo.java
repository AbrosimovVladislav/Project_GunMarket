package pro.va.gunmarket.domain.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Component
@Getter
@Setter
public class Ammo extends Product {
	public static final String AMMO_WEIGHT = "weight";

	@Column(name = AMMO_WEIGHT)
	private String weight;
}
