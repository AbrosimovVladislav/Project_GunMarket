package com.gunmarket.service;

import com.gunmarket.model.Product;
import com.gunmarket.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final Class PRODUCT_CLASS = Product.class;

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.getAll(PRODUCT_CLASS);
    }

}
