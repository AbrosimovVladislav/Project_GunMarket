package com.gunmarket.repository.basicRepo.repoUtils;

import com.gunmarket.web.webEntity.HttpParameter;
import com.gunmarket.web.webEntity.ParameterValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RepoUtils {

    public static Map<HttpParameter, List<ParameterValue>> addMarkersToParams(Map<HttpParameter, List<String>> params) {
        Map<HttpParameter, List<ParameterValue>> markedParamsMap = new TreeMap<>(
                (o1, o2) -> {
                    String o1ParamType = o1.getParamType();
                    String o2ParamType = o2.getParamType();
                    return o1ParamType.equals(o2ParamType)
                            ? o2.getParamName().compareTo(o1.getParamName())
                            : o2ParamType.compareTo(o1ParamType);
                });

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
