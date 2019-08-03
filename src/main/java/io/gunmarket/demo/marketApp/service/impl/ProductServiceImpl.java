package io.gunmarket.demo.marketApp.service.impl;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.repo.product.ProductRepo;
import io.gunmarket.demo.marketApp.service.ProductService;
import io.gunmarket.demo.marketApp.web.RequestParameter;
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
