package io.gunmarket.demo.marketApp.web.controller;

import io.gunmarket.demo.marketApp.model.domain.ProductInShop;
import io.gunmarket.demo.marketApp.service.ProductInShopService;
import io.gunmarket.demo.marketApp.web.validation.RequestParamsValidator;
import io.gunmarket.demo.marketApp.web.webentities.FilterAndPageable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ProductInShopController {

	private final ProductInShopService productInShopService;
	private final RequestParamsValidator validator;

	private static final int DEFAULT_PAGE_NUMBER = 0;
	private static final int DEFAULT_PAGE_SIZE = 10;

	@GetMapping(value = "/productsInShops", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ProductInShop> getAllByParams(@RequestParam Map<String, String> requestParams,
	                                          @PageableDefault(size = DEFAULT_PAGE_SIZE, page = DEFAULT_PAGE_NUMBER)
			                                          Pageable pageable) {
		FilterAndPageable pairOfParamsAndPageable = validator.validate(requestParams, pageable, ProductInShop.class);
		return productInShopService.getAllByParameters(pairOfParamsAndPageable.getFilter(),
				pairOfParamsAndPageable.getPageable()
		);
	}

	@GetMapping(value = "/productsInShops/{productId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ProductInShop> getByProductId(@PathVariable String productId,
	                                          @PageableDefault(size = DEFAULT_PAGE_SIZE, page = DEFAULT_PAGE_NUMBER)
			                                          Pageable pageable) {
		FilterAndPageable pairOfParamsAndPageable = validator.validate(Collections.singletonMap("product.productId", productId), pageable, ProductInShop.class);
		return productInShopService.getAllByParameters(pairOfParamsAndPageable.getFilter(),
				pairOfParamsAndPageable.getPageable()
		);
	}

}
