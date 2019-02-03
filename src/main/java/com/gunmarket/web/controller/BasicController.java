package com.gunmarket.web.controller;

import com.gunmarket.web.webEntity.HttpParameter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface BasicController {

    default Map<HttpParameter, List<String>> returnParams(Map<HttpParameter, String> rawParams) {
        Map<HttpParameter, List<String>> params = new HashMap<>();

        for (Map.Entry<HttpParameter, String> rawParamEntry : rawParams.entrySet()) {
            if (rawParamEntry.getValue() != null) {
                params.put(rawParamEntry.getKey(), Arrays.asList(rawParamEntry.getValue().split(",")));
            }
        }

        return params;
    }

}
