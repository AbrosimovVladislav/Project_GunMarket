package com.gunmarket.repository.repoUtils;

import com.gunmarket.web.webEntity.HttpParameter;
import com.gunmarket.web.webEntity.ParameterValue;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.gunmarket.repository.basicRepo.repoUtils.RepoUtils.*;
import static com.gunmarket.web.webEntity.HttpParameter.PARAM_CLASS_STRING;
import static com.gunmarket.web.webEntity.HttpParameter.SIMPLE_PARAM_TYPE;
import static java.util.Collections.singletonMap;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class RepoUtilsTest {

    @Test
    public void testAddMarkersToParams() {
        Map<HttpParameter, List<String>> basicParams = singletonMap(
                new HttpParameter("Name", SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, "Gun"),
                Arrays.asList("1", "2"));

        Map<HttpParameter, List<ParameterValue>> expectedParams = singletonMap(
                new HttpParameter("Name", SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, "Gun"),
                Arrays.asList(new ParameterValue("1"), new ParameterValue("2")));

        Map<HttpParameter, List<ParameterValue>> resultParams = addMarkersToParams(basicParams);

        assertEquals(resultParams.keySet().iterator().next(), expectedParams.keySet().iterator().next());
        assertEquals(resultParams.values().iterator().next().get(0).getValue()
                        + resultParams.values().iterator().next().get(1).getValue(),
                expectedParams.values().iterator().next().get(0).getValue()
                        + expectedParams.values().iterator().next().get(1).getValue());
    }

    @Test
    public void testReplaceLastChar() {
        assertEquals(replaceLastChar("String"), "Strin");
        assertEquals(replaceLastChar(""), "");
        assertNull(replaceLastChar(null));
    }

    @Test
    public void testFirstUpperCase() {
        assertEquals(firstUpperCase("string"), "String");
        assertEquals(firstUpperCase(""), "");
        assertNull(firstUpperCase(null));
    }

}
