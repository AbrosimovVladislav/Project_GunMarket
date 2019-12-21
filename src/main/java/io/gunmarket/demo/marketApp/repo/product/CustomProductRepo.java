package io.gunmarket.demo.marketApp.repo.product;

import io.gunmarket.demo.marketApp.domain.product.Product;

import java.util.List;
import java.util.Map;

public interface CustomProductRepo {
	List<Product> findAllByParameters(Map<String, String> requestParams);
	List<Product> findWithSorting(Map<String, String> requestParams);
}
