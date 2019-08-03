package io.gunmarket.demo.marketApp.web.controller;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.service.impl.ProductServiceImpl;
import io.gunmarket.demo.marketApp.web.RequestParameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static io.gunmarket.demo.marketApp.domain.Brand.BRAND_TABLE;
import static io.gunmarket.demo.marketApp.domain.Caliber.CALIBER_TABLE;
import static io.gunmarket.demo.marketApp.domain.Type.TYPE_TABLE;
import static io.gunmarket.demo.marketApp.domain.WeaponPlatform.WEAPON_PLATFORM_TABLE;
import static io.gunmarket.demo.marketApp.domain.product.Gun.GUN_BARREL_LENGTH;
import static io.gunmarket.demo.marketApp.domain.product.Gun.GUN_CAPACITY;
import static io.gunmarket.demo.marketApp.domain.product.Gun.GUN_TOTAL_LENGTH;
import static io.gunmarket.demo.marketApp.domain.product.Part.PART_COLOR;
import static io.gunmarket.demo.marketApp.domain.product.Part.PART_PARAMS;
import static io.gunmarket.demo.marketApp.domain.product.Product.PRODUCT_DTYPE;
import static io.gunmarket.demo.marketApp.domain.product.Product.PRODUCT_MODEL;
import static io.gunmarket.demo.marketApp.domain.product.Product.PRODUCT_WEIGHT;


@RestController
public class ProductController {
	private final ProductServiceImpl productServiceImpl;
	private static final Map<String, Boolean> parameterTypes = new HashMap<String, Boolean>() {{
		put(PRODUCT_DTYPE, false);
		put(PRODUCT_MODEL, false);
		put(GUN_BARREL_LENGTH, false);
		put(GUN_TOTAL_LENGTH, false);
		put(GUN_CAPACITY, false);
		put(PRODUCT_WEIGHT, false);
		put(PART_COLOR, false);
		put(PART_PARAMS, false);
		put(BRAND_TABLE, true);
		put(CALIBER_TABLE, true);
		put(TYPE_TABLE, true);
		put(WEAPON_PLATFORM_TABLE, true);
	}};

	public ProductController(ProductServiceImpl productServiceImpl) {
		this.productServiceImpl = productServiceImpl;
	}

	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Product> getAllByParams(@RequestParam Map<String, String> params) {
		Set<RequestParameter> requestParameters = params.entrySet()
				.stream()
				.filter(param -> parameterTypes.containsKey(param.getKey()))
				.filter(param -> param.getValue() != null)
				.map(param -> new RequestParameter(
						param.getKey(),
						param.getValue(),
						parameterTypes.get(param.getKey())
				))
				.collect(Collectors.toSet());
		return productServiceImpl.getAllByParameters(requestParameters);
	}
}
