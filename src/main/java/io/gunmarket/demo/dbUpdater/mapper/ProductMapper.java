package io.gunmarket.demo.dbUpdater.mapper;

import io.gunmarket.demo.dbUpdater.kadastr.gost.GostProduct;
import io.gunmarket.demo.marketApp.domain.Brand;
import io.gunmarket.demo.marketApp.domain.Type;
import io.gunmarket.demo.marketApp.domain.product.Ammo;
import io.gunmarket.demo.marketApp.domain.product.Gun;
import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.repo.BrandRepo;
import io.gunmarket.demo.marketApp.repo.TypeRepo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper implements InitializingBean {

	private final TypeRepo typeRepo;

	private final BrandRepo brandRepo;

	private List<Type> TYPES;

	private List<Brand> BRANDS;

	public ProductMapper(TypeRepo typeRepo, BrandRepo brandRepo) {
		this.typeRepo = typeRepo;
		this.brandRepo = brandRepo;
	}

	@Override
	public void afterPropertiesSet() {
		TYPES = this.typeRepo.findAll();
		BRANDS = this.brandRepo.findAll();
	}

	public List<Product> fromGost(List<GostProduct> gostProducts) {
		List<Product> products = new ArrayList<>();

		for (GostProduct gostProduct : gostProducts) {
			String model = gostProduct.getName();
			String brand = gostProduct.getBrand();
			Type type = getTypeFromGostCategory(gostProduct.getGostInternalId());
			String info = getInfoFromGostTechnicalIndicators(gostProduct.getTechnicalIndicators());

			Product product;

			if (type == null) {
				continue;
			}

			switch (type.getDType()) {
				case "Gun":
					product = new Gun();
					break;

				case "Ammo":
					product = new Ammo();
					break;

				default:
					throw new RuntimeException("Wrong dType. Not Gun and not Ammo");
			}

			product.setModel(model);
			product.setBrand(getBrandFromGostBrand(brand));
			product.setType(type);
			product.setInfo(info);
			products.add(product);
		}

		return products;
	}

	private String getInfoFromGostTechnicalIndicators(String technicalIndicators) {
		return technicalIndicators;
	}

	private Brand getBrandFromGostBrand(String gostBrand) {
		return BRANDS.stream().filter(brand -> gostBrand.contains(brand.getShortName())).findFirst().orElseThrow();
	}

	private Type getTypeFromGostCategory(String gostCategory) {
		return TYPES.stream()
				.filter(type -> type.getCategoryIdentifiers().contains(gostCategory))
				.findFirst()
				.orElse(null);
	}

}
