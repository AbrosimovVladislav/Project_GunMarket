package com.gunmarket.repository.basicRepo.queryBuilder;

import com.gunmarket.web.webEntity.HttpParameter;
import com.gunmarket.web.webEntity.ParameterValue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.gunmarket.model.product.Gun.GUN_ENTITY;
import static com.gunmarket.web.webEntity.HttpParameter.*;
import static org.testng.Assert.assertEquals;


public class QueryBuilderTest {

    private QueryBuilder queryBuilder = new QueryBuilder();

    /**
     * Testing plan
     * test with one parameter in paramsMap
     * test with three parameter in paramsMap
     */
    @BeforeMethod
    public void setUp() {

    }

    @Test
    public void testWithOneParameter() {
        Map<HttpParameter, List<ParameterValue>> params = new HashMap<HttpParameter, List<ParameterValue>>() {{
            put(new HttpParameter("First", SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING,GUN_ENTITY),
                    newArrayList(new ParameterValue("1")));
        }};

        String buildResult = queryBuilder.build("Product", params);
        String actualValue = buildResult.replaceAll("\\d", "");
        String expectedValue = "FROM Product WHERE (First = :pv )";

        assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testWithThreeParameters() {
        Map<HttpParameter, List<ParameterValue>> params = new HashMap<HttpParameter, List<ParameterValue>>() {{
            put(new HttpParameter("Thirds", COMPLEX_PARAM_TYPE, PARAM_CLASS_STRING,GUN_ENTITY),
                    newArrayList(new ParameterValue("3")));
            put(new HttpParameter("Second", OBJECTSIMPLE_PARAM_TYPE, PARAM_CLASS_STRING,GUN_ENTITY),
                    newArrayList(new ParameterValue("2")));
            put(new HttpParameter("First", SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING,GUN_ENTITY),
                    newArrayList(new ParameterValue("1")));
        }};

        String buildResult = queryBuilder.build("Product", params);
        String actualValue = buildResult.replaceAll("\\d", "");
        String expectedValue = "FROM Product WHERE (First = :pv ) " +
                "AND product_Id IN (FROM Product WHERE (Second_id = :pv )) " +
                "AND product_Id IN (SELECT Products.product_Id FROM  Third " +
                "AS Third LEFT JOIN Third.products Products WHERE Third.Third_Id = :pv )";

        assertEquals(actualValue, expectedValue);
    }

}
