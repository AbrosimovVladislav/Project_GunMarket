package io.gunmarket.demo.marketApp.repo.product;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.web.RequestParameter;

import java.util.List;
import java.util.Set;

public interface CustomProductRepo {
	List<Product> findAllByParameters(Set<RequestParameter> requestParams);
}
