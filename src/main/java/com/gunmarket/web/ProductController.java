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
import static com.gunmarket.model.Type.TYPE_ID;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Product> getProductsByParams(@RequestParam(value = PRODUCT_PRICE, required = false) String price
            , @RequestParam(value = TYPE_ID, required = false) String typeId
            , @RequestParam(value = PRODUCT_SHOPS, required = false) String shops) {
        Map<String, List<String>> params = new HashMap<String, List<String>>();
        if (price != null) {
            params.put(PRODUCT_PRICE, Arrays.asList(price.split(",")));
        }
        if (typeId != null) {
            params.put(TYPE_ID, Arrays.asList(typeId.split(",")));
        }
        if (shops != null) {
            params.put(PRODUCT_SHOPS, Arrays.asList(shops.split(",")));
        }

        return productService.getProductsByParams(params);
    }

}
