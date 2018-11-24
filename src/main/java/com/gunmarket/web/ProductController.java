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

    @Autowired
    ProductService productService;

        @RequestMapping(value = "/productsByParams", method = RequestMethod.GET, headers = "Accept=application/json")
        public List<Product> getProductsByParams(@RequestParam(value = "price", required = false) String price
                , @RequestParam(value = "type", required = false) String type) {
            Map<String,List<String>> params = new HashMap<String,List<String>>();
            if(price!=null){
                params.put("price", Arrays.asList(price.split(",")));
            }
            if(type!=null){
                params.put("type", Arrays.asList(type.split(",")));
            }

            return productService.getProductsByParams(params);
        }

/*    @RequestMapping(value = "/productsByParamsX", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Product> getProductsByParams(@RequestParam(value = "filter", required = false) String filter) {
        Map<String,List<String>> params = new HashMap<String,List<String>>();

        *//*for (String element : filter.split(";")) {
            String paramName = element.substring(0,element.indexOf(":")-1);
            List<String> paramValue = new ArrayList<String>();
            for (String paramValueElement : element.substring(element.indexOf(":")-1)) {

            }
            params.put(paramName,paramValue);
        }*//*
        //filter=price:350,400;type.id:1

        return productService.getProductsByParams(params);
    }*/

    @RequestMapping(value = "/allProducts", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

}