package io.gunmarket.demo.marketApp.web.controller;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.service.impl.ProductInShopServiceImpl;
import io.gunmarket.demo.marketApp.service.impl.ProductServiceImpl;
import io.gunmarket.demo.marketApp.web.RequestParameter;
import lombok.RequiredArgsConstructor;
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
import static io.gunmarket.demo.marketApp.domain.ProductInShop.*;
import static io.gunmarket.demo.marketApp.domain.Type.TYPE_TABLE;
import static io.gunmarket.demo.marketApp.domain.WeaponPlatform.WEAPON_PLATFORM_TABLE;
import static io.gunmarket.demo.marketApp.domain.product.Gun.*;
import static io.gunmarket.demo.marketApp.domain.product.Part.PART_COLOR;
import static io.gunmarket.demo.marketApp.domain.product.Part.PART_PARAMS;
import static io.gunmarket.demo.marketApp.web.InputParamsMapper.mapEntryParamsToRequestParams;


@RestController
@RequiredArgsConstructor
public class ProductInShopController {

	private final ProductInShopServiceImpl productInShopServiceImpl;
	public static final Map<String, Boolean> parameterTypes = new HashMap<String, Boolean>() {{
		put(PRODUCT_IN_SHOP_PRICE, false);
		put(PRODUCT_IN_SHOP_SALE, false);
		put(PRODUCT_IN_SHOP_IN_STOCK, false);
	}};

	@GetMapping(value = "/productsInShops", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ProductInShop> getAllByParams(@RequestParam Map<String, String> params) {
		Set<RequestParameter> requestParameters = mapEntryParamsToRequestParams(params,parameterTypes);
		return productInShopServiceImpl.getAllByParameters(requestParameters);
	}

}
