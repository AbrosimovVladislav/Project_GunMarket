package io.gunmarket.demo.marketApp.web.controller;

import io.gunmarket.demo.marketApp.domain.Product;
import io.gunmarket.demo.marketApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static io.gunmarket.demo.marketApp.domain.Rating.RATING_VALUE_SORT;

@RestController
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Product> getAllByParams(@RequestParam Map<String, String> requestParams, Pageable pageable) {
		Pair<Map<String, String>, Pageable> pairOfParamsAndPageable = validate(requestParams, pageable);
		return productService.getAllByParameters(pairOfParamsAndPageable.getFirst(),
				pairOfParamsAndPageable.getSecond());
	}

	private Pair<Map<String, String>, Pageable> validate(Map<String, String> requestParams, Pageable pageable) {
		String sortParam = requestParams.remove("sort");
		if (sortParam == null) return Pair.of(requestParams, getDefaultSortingProperty(pageable));
		String sortProp = sortParam.substring(0, sortParam.indexOf(","));
		Sort sort = Sort.by(pageable.getSort().getOrderFor(sortProp));
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
		return Pair.of(requestParams, pageRequest);
	}

	private static PageRequest getDefaultSortingProperty(Pageable pageable) {
		return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(RATING_VALUE_SORT));
	}
}
