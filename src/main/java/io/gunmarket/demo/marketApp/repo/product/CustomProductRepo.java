package io.gunmarket.demo.marketApp.repo.product;

import io.gunmarket.demo.marketApp.domain.product.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CustomProductRepo {

	List<Product> findAllByParameters(Map<String, String> requestParams, Pageable pageable);

}
