package io.gunmarket.demo.marketApp.web.dto;

import io.gunmarket.demo.marketApp.domain.Brand;
import io.gunmarket.demo.marketApp.domain.Caliber;
import io.gunmarket.demo.marketApp.domain.Rating;
import io.gunmarket.demo.marketApp.domain.Type;
import io.gunmarket.demo.marketApp.domain.WeaponPlatform;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Setter
@Getter
@Accessors(chain = true)
public class ProductDto {
	/*@NonNull */private Long productId;
	/*@NonNull */private String productType;
	/*@Nullable*/ private String info;
	/*@NonNull */private String link;
	/*@NonNull */private String imageLink;
	/*@NonNull */private String model;
	/*@Nullable*/ private String weight;
	/*@Nullable*/ private String capacity;
	/*@Nullable*/ private String totalLength;
	/*@Nullable*/ private String barrelLength;
	/*@Nullable*/ private String params;
	/*@Nullable*/ private String color;
	/*@NonNull */private Brand brand;
	/*@NonNull */private Type type;
	/*@Nullable*/ private Caliber caliber;
	/*@Nullable*/ private WeaponPlatform weaponPlatform;
	/*@NonNull */private Rating rating;
	/*@NonNull */private Double minPrice;
}
