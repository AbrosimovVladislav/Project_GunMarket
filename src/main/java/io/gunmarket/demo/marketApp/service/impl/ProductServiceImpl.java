package io.gunmarket.demo.marketApp.service.impl;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.repo.product.ProductRepo;
import io.gunmarket.demo.marketApp.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepo productRepo;

	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	public List<Product> getAllByParameters(Map<String, String> requestParams) {
		return productRepo.findAllByParameters(requestParams);
	}

}
