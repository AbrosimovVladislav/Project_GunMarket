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

import static io.gunmarket.demo.marketApp.domain.Brand.BRAND_TABLE;
import static io.gunmarket.demo.marketApp.domain.Caliber.CALIBER_TABLE;
import static io.gunmarket.demo.marketApp.domain.Type.TYPE_TABLE;
import static io.gunmarket.demo.marketApp.domain.WeaponPlatform.WEAPON_PLATFORM_TABLE;
import static io.gunmarket.demo.marketApp.domain.product.Gun.*;
import static io.gunmarket.demo.marketApp.domain.product.Part.PART_COLOR;
import static io.gunmarket.demo.marketApp.domain.product.Part.PART_PARAMS;
import static io.gunmarket.demo.marketApp.web.InputParamsMapper.mapEntryParamsToRequestParams;


@RestController
public class ProductController {
	private final ProductServiceImpl productServiceImpl;
	public static final Map<String, Boolean> parameterTypes = new HashMap<>() {{
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
		Set<RequestParameter> requestParameters = mapEntryParamsToRequestParams(params, parameterTypes);
		return productServiceImpl.getAllByParameters(requestParameters);
	}
}
