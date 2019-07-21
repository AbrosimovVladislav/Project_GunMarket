package io.gunmarket.demo.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gunmarket.demo.product.domain.product.Product;
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

import static io.gunmarket.demo.product.domain.WeaponPlatform.WEAPON_PLATFORM_TABLE;


@Entity
@Table(name = WEAPON_PLATFORM_TABLE)
@Getter
@Setter
@ToString(exclude = {"products"})
public class WeaponPlatform {
	public static final String WEAPON_PLATFORM_TABLE = "weaponPlatform";
	public static final String WEAPON_PLATFORM_ID = "weaponPlatform_id";
	public static final String WEAPON_PLATFORM_NAME = "name";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = WEAPON_PLATFORM_ID, length = 8, nullable = false)
	private Long weaponPlatformId;

	@Column(name = WEAPON_PLATFORM_NAME)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = WEAPON_PLATFORM_TABLE)
	Set<Product> products;

}
