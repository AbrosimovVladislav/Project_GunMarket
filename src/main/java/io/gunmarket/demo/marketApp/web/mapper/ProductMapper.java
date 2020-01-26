package io.gunmarket.demo.marketApp.web.mapper;

import io.gunmarket.demo.marketApp.model.domain.product.Product;
import io.gunmarket.demo.marketApp.service.ProductInShopService;
import io.gunmarket.demo.marketApp.web.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

	private final ProductInShopService productInShopService;

	public ProductDto map(Product product) {
		return new ProductDto().setProductId(product.getProductId())
				.setProductType(product.getProductType().name())
				.setInfo(product.getInfo())
				.setLink(product.getLink())
				.setImageLink(product.getImageLink())
				.setModel(product.getModel())
				.setWeight(product.getWeight())
				.setCapacity(product.getCapacity())
				.setTotalLength(product.getTotalLength())
				.setBarrelLength(product.getBarrelLength())
				.setParams(product.getParams())
				.setColor(product.getColor().name())
				.setOperatingPrinciple(product.getOperatingPrinciple().name())
				.setCondition(product.getCondition().name())
				.setBarrelOrientation(product.getBarrelOrientation() != null ? product.getBarrelOrientation().name() : null)
				.setCountry(product.getCountry() != null ? product.getCountry().name() : null)
				.setSleeveMaterial(product.getSleeveMaterial() != null ? product.getSleeveMaterial().name() : null)
				.setChargeType(product.getChargeType() != null ? product.getChargeType().name() : null)
				.setBrand(product.getBrand())
				.setType(product.getType())
				.setCaliber(product.getCaliber())
				.setWeaponPlatform(product.getWeaponPlatform())
				.setRating(product.getRating())
				.setMinPrice(productInShopService.calculateMinPriceByProduct(product.getProductId()));
	}
}