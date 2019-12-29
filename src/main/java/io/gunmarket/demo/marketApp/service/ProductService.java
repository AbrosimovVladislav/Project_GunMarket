package io.gunmarket.demo.marketApp.service;

import io.gunmarket.demo.marketApp.domain.Product;
import io.gunmarket.demo.marketApp.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepo productRepo;

	public List<Product> getAllByParameters(Map<String, String> requestParams, Pageable pageable) {
		return productRepo.findAllByParameters(requestParams, pageable, Product.class);
	}

	public Product getById(String id){
		return productRepo.findAllByProductId(Long.valueOf(id));
	}

}
