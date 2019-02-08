package com.gunmarket.repository.basicRepo.repoUtils;

import com.gunmarket.web.webEntity.HttpParameter;
import com.gunmarket.web.webEntity.ParameterValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepoUtils {

    public static Map<HttpParameter, List<ParameterValue>> addMarkersToParams(Map<HttpParameter, List<String>> params) {
        Map<HttpParameter, List<ParameterValue>> markedParamsMap = new HashMap<>();

        params.forEach((httpParameter, parameterValueName) -> markedParamsMap.put(
                httpParameter,
                parameterValueName.stream()
                        .map(ParameterValue::new)
                        .collect(Collectors.toList())
        ));

        return markedParamsMap;
    }

    public static String replaceLastChar(String str) {
        return str == null || str.isEmpty()
                ? str
                : str.substring(0, str.length() - 1);
    }

    public static String firstUpperCase(String word) {
        return word == null || word.isEmpty()
                ? word
                : word.substring(0, 1).toUpperCase() + word.substring(1);
    }

}
