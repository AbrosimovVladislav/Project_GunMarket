package com.gunmarket.repository.basicRepo.repoUtils;

import com.gunmarket.web.HttpParameter;
import com.gunmarket.web.ParameterValue;

import java.util.*;

public class RepoUtils {

    public static Map<HttpParameter, List<ParameterValue>> addMarkersToParams(Map<HttpParameter, List<String>> params) {
        Map<HttpParameter, List<ParameterValue>> markedParamsMap = new HashMap<>();

        for (Map.Entry<HttpParameter, List<String>> paramEntry : params.entrySet()) {
            HttpParameter markedMapKey = paramEntry.getKey();
            List<ParameterValue> markedMapValues = new ArrayList<>();

            for (String value : paramEntry.getValue()) {
                markedMapValues.add(new ParameterValue(value));
            }

            markedParamsMap.put(markedMapKey, markedMapValues);

        }

        return markedParamsMap;
    }

    public static Map<HttpParameter, List<ParameterValue>> sortParamsMap(Map<HttpParameter, List<ParameterValue>> params) {
        List<Map.Entry<HttpParameter, List<ParameterValue>>> list = new ArrayList(params.entrySet());

        list.sort(new Comparator<Map.Entry<HttpParameter, List<ParameterValue>>>() {
            public int compare(Map.Entry<HttpParameter, List<ParameterValue>> o1, Map.Entry<HttpParameter, List<ParameterValue>> o2) {
                return (o2.getKey().getParamType()).compareTo(o1.getKey().getParamType());
            }
        });

        Map<HttpParameter, List<ParameterValue>> sortedMap = new LinkedHashMap();
        for (Map.Entry<HttpParameter, List<ParameterValue>> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static String replaceLastChar(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

}
