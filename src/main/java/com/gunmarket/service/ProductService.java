package com.gunmarket.service;

import com.gunmarket.model.Product;
import com.gunmarket.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final String PRODUCT_ENTITY = "Product";
    private final Class PRODUCT_CLASS = Product.class;

    @Autowired
    private ProductRepo productRepo;

    public void addProduct(Product product) {
        productRepo.add(product);
    }

    public Product getProductByParam(String paramName, String paramValue) {
        return (Product) productRepo.getByParam(paramName, paramValue, PRODUCT_ENTITY, PRODUCT_CLASS);
    }

    public List<Product> getAllProducts() {
        return productRepo.getAll(PRODUCT_ENTITY, PRODUCT_CLASS);
    }

}
