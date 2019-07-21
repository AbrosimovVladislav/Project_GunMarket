package io.gunmarket.demo.domain;

import io.gunmarket.demo.domain.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

import static io.gunmarket.demo.domain.WeaponPlatform.WEAPON_PLATFORM_TABLE;


@Entity
@Table(name = WEAPON_PLATFORM_TABLE)
@Getter
@Setter
public class WeaponPlatform {
	public static final String WEAPON_PLATFORM_TABLE = "weaponPlatform";
	public static final String WEAPON_PLATFORM_ID = "weaponPlatformId";
	public static final String WEAPON_PLATFORM_NAME = "name";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = WEAPON_PLATFORM_ID, length = 8, nullable = false)
	private Long weaponPlatformId;

	@Column(name = WEAPON_PLATFORM_NAME)
	private String name;

	@OneToMany(mappedBy = WEAPON_PLATFORM_TABLE)
	Set<Product> products;

}