package io.gunmarket.demo.dbUpdater.mapper;

import io.gunmarket.demo.dbUpdater.kadastr.gost.GostProduct;
import io.gunmarket.demo.marketApp.domain.Brand;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BrandMapper {

	public Set<Brand> fromGostProduct(List<GostProduct> gostProducts) {
		Set<Brand> brands = new HashSet<>();

		gostProducts.forEach(gostProduct -> {

			String brandName = gostProduct.getBrand();

			Brand brand = new Brand();
			brand.setFullName(brandName);
			brand.setShortName(getBrandShortName(brandName));
			brands.add(brand);
		});

		return brands;
	}

	//ToDO not implemented
	private String getBrandShortName(String fullName) {
		return fullName;
	}

}
