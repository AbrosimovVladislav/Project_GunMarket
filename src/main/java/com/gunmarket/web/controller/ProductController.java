package com.gunmarket.web.controller;

import com.gunmarket.model.product.Product;
import com.gunmarket.service.ProductService;
import com.gunmarket.web.webEntity.HttpParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gunmarket.model.product.Gun.GUN_ENTITY;
import static com.gunmarket.model.product.Product.PRODUCT_PRICE;
import static com.gunmarket.model.product.Product.PRODUCT_SHOPS;
import static com.gunmarket.web.webEntity.HttpParameter.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<? super Product> getProductsByParams(@RequestParam(value = PRODUCT_PRICE, required = false) String price,
                                                     @RequestParam(value = PRODUCT_SHOPS, required = false) String shops) {
        Map<HttpParameter, List<String>> params = new HashMap<>();
        if (price != null) {
            params.put(new HttpParameter(PRODUCT_PRICE, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING,GUN_ENTITY), Arrays.asList(price.split(",")));
        }
        if (shops != null) {
            params.put(new HttpParameter(PRODUCT_SHOPS, COMPLEX_PARAM_TYPE, PARAM_CLASS_LONG,GUN_ENTITY), Arrays.asList(shops.split(",")));
        }

        return productService.getProductsByParams(params);
    }

}
