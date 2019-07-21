package io.gunmarket.demo.repo;

import io.gunmarket.demo.domain.product.Product;
import io.gunmarket.demo.web.RequestParameter;

import java.util.List;
import java.util.Set;


public interface ProductRepo {
	List<Product> findAllByParameters(Set<RequestParameter> requestParams);
}
