package io.gunmarket.demo.marketApp.web.controller;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.service.impl.ProductServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class ProductController {
	private final ProductServiceImpl productServiceImpl;

	public ProductController(ProductServiceImpl productServiceImpl) {
		this.productServiceImpl = productServiceImpl;
	}

	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Product> getAllByParams(@RequestParam Map<String, String> requestParams) {
		return productServiceImpl.getAllByParameters(requestParams);
	}

}
