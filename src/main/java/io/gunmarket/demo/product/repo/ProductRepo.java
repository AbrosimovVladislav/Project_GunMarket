package io.gunmarket.demo.product.repo;

import io.gunmarket.demo.product.domain.product.Product;
import io.gunmarket.demo.product.web.RequestParameter;

import java.util.List;
import java.util.Set;


public interface ProductRepo {
	List<Product> findAllByParameters(Set<RequestParameter> requestParams);
}
