package com.gunmarket.temp;

import com.gunmarket.repository.basicRepo.queryBuilder.QueryBuilder;
import com.gunmarket.web.webEntity.HttpParameter;
import com.gunmarket.web.webEntity.ParameterValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.gunmarket.model.product.Gun.GUN_ENTITY;
import static com.gunmarket.web.webEntity.HttpParameter.*;


public class TempTest {

    //FROM Product WHERE (Second = :p6725387959629711552v ) AND product_Id IN (SELECT Products.product_Id FROM  Firs AS Firs LEFT JOIN Firs.products Products WHERE Firs.Firs_Id = :p5477720165956593881v ) AND product_Id IN (FROM Product WHERE (Third_id = :p5057594998588424548v ))
    //FROM Product WHERE (Second = :p4905727906915488259v ) AND product_Id IN (SELECT Products.product_Id FROM  Firs AS Firs LEFT JOIN Firs.products Products WHERE Firs.Firs_Id = :p5487059439350119188v ) AND product_Id IN (FROM Product WHERE (Third_id = :p6600343913088077532v ))


    public static void main(String[] args) {
        QueryBuilder queryBuilder = new QueryBuilder();

        Map<HttpParameter, List<ParameterValue>> params = new HashMap<HttpParameter, List<ParameterValue>>() {
            {
                put(new HttpParameter("First", COMPLEX_PARAM_TYPE, PARAM_CLASS_STRING,GUN_ENTITY),
                        newArrayList(new ParameterValue("1")));
                put(new HttpParameter("Second", SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING,GUN_ENTITY),
                        newArrayList(new ParameterValue("2")));
                put(new HttpParameter("Third", OBJECTSIMPLE_PARAM_TYPE, PARAM_CLASS_STRING,GUN_ENTITY),
                        newArrayList(new ParameterValue("3")));
            }
        };

        String query = queryBuilder.build("Product", params);

        System.out.println(query);
    }

}
