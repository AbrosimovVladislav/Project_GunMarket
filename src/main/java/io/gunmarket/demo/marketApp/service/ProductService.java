package io.gunmarket.demo.marketApp.service;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.web.RequestParameter;

import java.util.List;
import java.util.Set;


public interface ProductService {
	List<Product> getAllByParameters(Set<RequestParameter> requestParams);
}
