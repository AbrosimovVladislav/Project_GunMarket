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

import static com.gunmarket.model.product.Part.*;
import static com.gunmarket.model.product.Product.PRODUCT_CATEGORY;
import static com.gunmarket.model.product.Product.PRODUCT_MANUFACTURER;
import static com.gunmarket.model.product.Product.PRODUCT_PRICE;
import static com.gunmarket.model.product.Product.PRODUCT_SHOPS;
import static com.gunmarket.web.webEntity.HttpParameter.*;

@RestController
public class PartController implements BasicController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/parts", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<? super Product> getPartsByParams(
            @RequestParam(value = PRODUCT_PRICE, required = false) String price,
            @RequestParam(value = PRODUCT_MANUFACTURER, required = false) String manufacturer,
            @RequestParam(value = PRODUCT_CATEGORY, required = false) String category,
            @RequestParam(value = PRODUCT_SHOPS, required = false) String shops,
            @RequestParam(value = PART_SUBCATEGORY, required = false) String subcategory,
            @RequestParam(value = PART_FAMILY, required = false) String family,
            @RequestParam(value = PART_INNER_OR_OUTER, required = false) String innerOrOuter
    ) {
        return productService.getProductsByParams(
                returnParams(new HashMap<HttpParameter, String>() {
                    {
                        put(new HttpParameter(PRODUCT_PRICE, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, PART_ENTITY), price);
                        put(new HttpParameter(PRODUCT_MANUFACTURER, OBJECTSIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, PART_ENTITY), manufacturer);
                        put(new HttpParameter(PRODUCT_CATEGORY, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, PART_ENTITY), category);
                        put(new HttpParameter(PRODUCT_SHOPS, COMPLEX_PARAM_TYPE, PARAM_CLASS_LONG, PART_ENTITY), shops);
                        put(new HttpParameter(PART_SUBCATEGORY, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, PART_ENTITY), subcategory);
                        put(new HttpParameter(PART_FAMILY, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, PART_ENTITY), family);
                        put(new HttpParameter(PART_INNER_OR_OUTER, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, PART_ENTITY), innerOrOuter);
                    }
                }));
    }

}
