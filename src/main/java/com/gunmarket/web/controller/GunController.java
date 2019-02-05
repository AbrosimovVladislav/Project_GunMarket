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

import static com.gunmarket.model.product.Gun.*;
import static com.gunmarket.model.product.Gun.PRODUCT_CALIBER;
import static com.gunmarket.model.product.Product.PRODUCT_CATEGORY;
import static com.gunmarket.model.product.Product.PRODUCT_MANUFACTURER;
import static com.gunmarket.model.product.Product.PRODUCT_PRICE;
import static com.gunmarket.model.product.Product.PRODUCT_SHOPS;
import static com.gunmarket.web.webEntity.HttpParameter.*;

@RestController
public class GunController implements BasicController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/guns", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<? super Product> getGunsByParams(
            @RequestParam(value = PRODUCT_PRICE, required = false) String price,
            @RequestParam(value = PRODUCT_MANUFACTURER, required = false) String manufacturer,
            @RequestParam(value = PRODUCT_CATEGORY, required = false) String category,
            @RequestParam(value = PRODUCT_SHOPS, required = false) String shops,
            @RequestParam(value = PRODUCT_CALIBER, required = false) String caliber,
            @RequestParam(value = PRODUCT_WEAPON_PLATFORM, required = false) String family,
            @RequestParam(value = GUN_SUBCATEGORY, required = false) String subcategory
    ) {
        return productService.getProductsByParams(
                returnParams(new HashMap<HttpParameter, String>() {
                    {
                        put(new HttpParameter(PRODUCT_PRICE, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, GUN_ENTITY), price);
                        put(new HttpParameter(PRODUCT_MANUFACTURER, OBJECTSIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, GUN_ENTITY), manufacturer);
                        put(new HttpParameter(PRODUCT_CATEGORY, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, GUN_ENTITY), category);
                        put(new HttpParameter(PRODUCT_SHOPS, COMPLEX_PARAM_TYPE, PARAM_CLASS_LONG, GUN_ENTITY), shops);
                        put(new HttpParameter(PRODUCT_CALIBER, OBJECTSIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, GUN_ENTITY), caliber);
                        put(new HttpParameter(PRODUCT_WEAPON_PLATFORM, OBJECTSIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, GUN_ENTITY), family);
                        put(new HttpParameter(GUN_SUBCATEGORY, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, GUN_ENTITY), subcategory);
                    }
                }));
    }

}
