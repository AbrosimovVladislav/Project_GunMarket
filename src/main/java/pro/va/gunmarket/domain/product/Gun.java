package pro.va.gunmarket.domain.product;

import pro.va.gunmarket.domain.Caliber;
import pro.va.gunmarket.domain.WeaponPlatform;


public class Gun extends Product {
	private Caliber caliber;
	private String capacity;
	private String totalLength;
	private String barrelLength;
	private String weight;
	private WeaponPlatform weaponPlatform;
}
