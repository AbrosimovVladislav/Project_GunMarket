package io.gunmarket.demo.marketApp.service;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.repo.product.ProductRepo;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

	private final ProductRepo productRepo;

	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	public List<Product> getAllByParameters(Map<String, String> requestParams, Pageable pageable) {
		return productRepo.findAllByParameters(requestParams, pageable);
	}

}
