package com.gunmarket.repository.basicRepo.repoUtils;

import com.gunmarket.web.HttpParameter;
import com.gunmarket.web.ParameterValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RepoUtils {

    public static Map<HttpParameter, List<ParameterValue>> addMarkersToParams(Map<HttpParameter, List<String>> params) {
        Map<HttpParameter, List<ParameterValue>> markedParamsMap = new TreeMap<>((o1, o2) ->
                (o2.getParamType()).compareTo(o1.getParamType()));

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
