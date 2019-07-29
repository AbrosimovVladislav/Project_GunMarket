package io.gunmarket.demo.dbUpdater.web.controller;

import io.gunmarket.demo.dbUpdater.shop.armsline.ArmsLineParser;
import io.gunmarket.demo.product.domain.ProductInShop;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DbUpdaterController {

	private final ArmsLineParser armsLineParser;

	public DbUpdaterController(ArmsLineParser armsLineParser) {
		this.armsLineParser = armsLineParser;
	}

	@GetMapping(value = "/updateProductInShop/{parserName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ProductInShop> updateByParserName(@PathVariable String parserName) {
		return armsLineParser.updateArmsLineContent();
	}

}

/*
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

 */
