package com.gunmarket.service;

import com.gunmarket.model.Product;
import com.gunmarket.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private static final Class PRODUCT_CLASS = Product.class;
    private static final String PRODUCT_NAME = "Product";

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.getAll(PRODUCT_NAME, PRODUCT_CLASS);
    }

    public List<Product> getProductsByParams(Map<String,List<String>> params){
        return productRepo.getByParams(PRODUCT_NAME,PRODUCT_CLASS,params);
    }

}
