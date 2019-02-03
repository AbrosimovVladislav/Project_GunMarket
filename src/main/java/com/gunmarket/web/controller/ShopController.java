package com.gunmarket.web.controller;

import com.gunmarket.model.Shop;
import com.gunmarket.service.ShopService;
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

import static com.gunmarket.model.Shop.SHOP_ADDRESS;
import static com.gunmarket.model.Shop.SHOP_PRODUCTS;
import static com.gunmarket.model.product.Gun.GUN_ENTITY;
import static com.gunmarket.web.webEntity.HttpParameter.*;

@RestController
public class ShopController {

    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/shops", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<? super Shop> getShopsByParams(@RequestParam(value = SHOP_ADDRESS, required = false) String address
            , @RequestParam(value = SHOP_PRODUCTS, required = false) String products) {
        Map<HttpParameter, List<String>> params = new HashMap<>();
        if (address != null) {
            params.put(new HttpParameter(SHOP_ADDRESS, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING,GUN_ENTITY), Arrays.asList(address.split(",")));
        }
        if (products != null) {
            params.put(new HttpParameter(SHOP_PRODUCTS, COMPLEX_PARAM_TYPE, PARAM_CLASS_LONG,GUN_ENTITY), Arrays.asList(products.split(",")));
        }

        return shopService.getShopsByParams(params);
    }

}
