package com.gunmarket.web.controller;

import com.gunmarket.model.product.Product;
import com.gunmarket.service.ProductService;
import com.gunmarket.web.webEntity.HttpParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

import static com.gunmarket.model.product.Ammo.AMMO_CALIBER;
import static com.gunmarket.model.product.Ammo.AMMO_ENTITY;
import static com.gunmarket.model.product.Gun.GUN_ENTITY;
import static com.gunmarket.model.product.Product.*;
import static com.gunmarket.web.webEntity.HttpParameter.*;

@RestController
public class AmmoController implements BasicController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/ammo", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<? super Product> getProductsByParams(
            @RequestParam(value = PRODUCT_PRICE, required = false) String price,
            @RequestParam(value = PRODUCT_MANUFACTURER, required = false) String manufacturer,
            @RequestParam(value = PRODUCT_CATEGORY, required = false) String category,
            @RequestParam(value = PRODUCT_SHOPS, required = false) String shops,
            @RequestParam(value = AMMO_CALIBER, required = false) String caliber
    ) {
        return productService.getProductsByParams(
                returnParams(new HashMap<HttpParameter, String>() {
                    {
                        put(new HttpParameter(PRODUCT_PRICE, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, AMMO_ENTITY), price);
                        put(new HttpParameter(PRODUCT_MANUFACTURER, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, AMMO_ENTITY), manufacturer);
                        put(new HttpParameter(PRODUCT_CATEGORY, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, AMMO_ENTITY), category);
                        put(new HttpParameter(PRODUCT_SHOPS, COMPLEX_PARAM_TYPE, PARAM_CLASS_LONG, AMMO_ENTITY), shops);
                        put(new HttpParameter(AMMO_CALIBER, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, AMMO_ENTITY), caliber);
                    }
                }));
    }

}
