package io.gunmarket.demo.product.service.impl;

import io.gunmarket.demo.product.domain.product.Product;
import io.gunmarket.demo.product.repo.ProductRepo;
import io.gunmarket.demo.product.service.ProductService;
import io.gunmarket.demo.product.web.RequestParameter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepo productRepo;

	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	public List<Product> getAllByParameters(Set<RequestParameter> requestParams) {
		return productRepo.findAllByParameters(requestParams);
	}
}
