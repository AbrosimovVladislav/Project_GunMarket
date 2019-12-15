package io.gunmarket.demo.marketApp.service;

import io.gunmarket.demo.marketApp.domain.product.Product;

import java.util.List;
import java.util.Map;


public interface ProductService {
	List<Product> getAllByParameters(Map<String, String> params);
}
