package com.gunmarket.temp;

import com.gunmarket.repository.basicRepo.queryBuilder.QueryBuilder;
import com.gunmarket.web.HttpParameter;
import com.gunmarket.web.ParameterValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.gunmarket.web.HttpParameter.*;


public class TempTest {

    public static void main(String[] args) {
        QueryBuilder queryBuilder = new QueryBuilder();

        Map<HttpParameter, List<ParameterValue>> params = new HashMap<HttpParameter, List<ParameterValue>>() {
            {
                put(new HttpParameter("First", COMPLEX_PARAM_TYPE, PARAM_CLASS_STRING),
                        newArrayList(new ParameterValue("1")));
                put(new HttpParameter("Second", SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING),
                        newArrayList(new ParameterValue("2")));
                put(new HttpParameter("Third", OBJECTSIMPLE_PARAM_TYPE, PARAM_CLASS_STRING),
                        newArrayList(new ParameterValue("3")));
            }
        };

        String query = queryBuilder.build("Product", params);

        System.out.println(query);
    }

}
