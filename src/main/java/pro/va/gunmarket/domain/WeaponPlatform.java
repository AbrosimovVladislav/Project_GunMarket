package pro.va.gunmarket.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pro.va.gunmarket.domain.product.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

import static pro.va.gunmarket.domain.WeaponPlatform.WEAPON_PLATFORM_TABLE;


@Entity
@Component
@Table(name = WEAPON_PLATFORM_TABLE)
@Getter
@Setter
public class WeaponPlatform {
	public static final String WEAPON_PLATFORM_TABLE = "table";
	public static final String WEAPON_PLATFORM_ID = "id";
	public static final String WEAPON_PLATFORM_NAME = "name";

	@Column(name = WEAPON_PLATFORM_NAME)
	private String name;

	@OneToMany(mappedBy = WEAPON_PLATFORM_TABLE)
	Set<Product> products;
}
