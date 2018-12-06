package com.gunmarket.web;

import com.gunmarket.model.Product;
import com.gunmarket.service.ProductService;
import javafx.util.Pair;
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

    public static final String SIMPLE_PARAM_TYPE = "Simple";
    public static final String OBJECTSIMPLE_PARAM_TYPE = "ObjectSimple";
    public static final String COMPLEX_PARAM_TYPE = "Complex";

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Product> getProductsByParams(@RequestParam(value = PRODUCT_PRICE, required = false) String price
            , @RequestParam(value = TYPE_ID, required = false) String typeId
            , @RequestParam(value = PRODUCT_SHOPS, required = false) String shops) {
        Map<Pair<String,String>, List<String>> params = new HashMap<>();
        if (price != null) {
            params.put(new Pair<String,String>(PRODUCT_PRICE,SIMPLE_PARAM_TYPE), Arrays.asList(price.split(",")));
        }
        if (typeId != null) {
            params.put(new Pair<String,String>(TYPE_ID,OBJECTSIMPLE_PARAM_TYPE), Arrays.asList(typeId.split(",")));
        }
        if (shops != null) {
            params.put(new Pair<String,String>(PRODUCT_SHOPS,COMPLEX_PARAM_TYPE), Arrays.asList(shops.split(",")));
        }

        return productService.getProductsByParams(params);
    }

}
