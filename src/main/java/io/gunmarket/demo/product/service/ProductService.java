package io.gunmarket.demo.product.service;

import io.gunmarket.demo.product.domain.product.Product;
import io.gunmarket.demo.product.web.RequestParameter;

import java.util.List;
import java.util.Set;


public interface ProductService {
	List<Product> getAllByParameters(Set<RequestParameter> requestParams);
}
