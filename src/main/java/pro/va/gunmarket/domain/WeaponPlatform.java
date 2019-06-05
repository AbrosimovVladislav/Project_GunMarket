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

import static pro.va.gunmarket.domain.Type.TYPE_ID;
import static pro.va.gunmarket.domain.WeaponPlatform.WEAPON_PLATFORM_TABLE;


@Entity
@Component
@Table(name = WEAPON_PLATFORM_TABLE)
@Getter
@Setter
public class WeaponPlatform {
	public static final String WEAPON_PLATFORM_TABLE = "weaponPlatform";
	public static final String WEAPON_PLATFORM_ID = "weaponPlatformId";
	public static final String WEAPON_PLATFORM_NAME = "name";

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = TYPE_ID, length = 8, nullable = false)
	private Long weaponPlatformId;

	@Column(name = WEAPON_PLATFORM_NAME)
	private String name;

	@OneToMany(mappedBy = WEAPON_PLATFORM_TABLE)
	Set<Product> products;

}
