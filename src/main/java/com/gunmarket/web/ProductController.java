package com.gunmarket.web;

import com.gunmarket.model.Product;
import com.gunmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gunmarket.model.Product.PRODUCT_PRICE;
import static com.gunmarket.model.Product.PRODUCT_SHOPS;
import static com.gunmarket.model.Type.TYPE_ENTITY;
import static com.gunmarket.web.HttpParameter.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Product> getProductsByParams(@RequestParam(value = PRODUCT_PRICE, required = false) String price
            , @RequestParam(value = TYPE_ENTITY, required = false) String type
            , @RequestParam(value = PRODUCT_SHOPS, required = false) String shops) {
        Map<HttpParameter, List<String>> params = new HashMap<>();
        if (price != null) {
            params.put(new HttpParameter(PRODUCT_PRICE, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING), Arrays.asList(price.split(",")));
        }
        if (type != null) {
            params.put(new HttpParameter(TYPE_ENTITY, OBJECTSIMPLE_PARAM_TYPE, PARAM_CLASS_LONG), Arrays.asList(type.split(",")));
        }
        if (shops != null) {
            params.put(new HttpParameter(PRODUCT_SHOPS, COMPLEX_PARAM_TYPE, PARAM_CLASS_LONG), Arrays.asList(shops.split(",")));
        }

        return productService.getProductsByParams(params);
    }

}
