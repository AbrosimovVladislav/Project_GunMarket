package io.gunmarket.demo.service;

import io.gunmarket.demo.domain.product.Product;
import io.gunmarket.demo.repo.ProductRepo;
import io.gunmarket.demo.web.RequestParameter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class ProductService {
	private final ProductRepo productRepo;

	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	public List<Product> getAllByParameters(Set<RequestParameter> requestParams) {
		return productRepo.findAllByParameters(requestParams);
	}
}
