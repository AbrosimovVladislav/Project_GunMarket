package com.gunmarket.web;

import com.gunmarket.model.Product;
import com.gunmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;

@RestController
public class ProductController {

    private static final String PRICE_NAME = "price";
    private static final String TYPEID_NAME = "type_id";

    @Autowired
    ProductService productService;

        @RequestMapping(value = "/productsByParams", method = RequestMethod.GET, headers = "Accept=application/json")
        public List<Product> getProductsByParams(@RequestParam(value = PRICE_NAME, required = false) String price
                , @RequestParam(value = TYPEID_NAME, required = false) String typeId) {
            Map<String,List<String>> params = new HashMap<String,List<String>>();
            if(price!=null){
                params.put(PRICE_NAME, Arrays.asList(price.split(",")));
            }
            if(typeId!=null){
                params.put(TYPEID_NAME, Arrays.asList(typeId.split(",")));
            }

            return productService.getProductsByParams(params);
        }

    @RequestMapping(value = "/allProducts", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

}