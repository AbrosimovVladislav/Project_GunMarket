package com.gunmarket.repository.basicRepo.repoUtils;

import com.gunmarket.web.HttpParameter;

import java.util.*;

public class RepoUtils {

    public static Map<HttpParameter, List<String>> sortParamsMap(Map<HttpParameter, List<String>> params) {
        List<Map.Entry<HttpParameter, List<String>>> list = new ArrayList(params.entrySet());

        list.sort(new Comparator<Map.Entry<HttpParameter, List<String>>>() {
            public int compare(Map.Entry<HttpParameter, List<String>> o1, Map.Entry<HttpParameter, List<String>> o2) {
                return (o2.getKey().getParamType()).compareTo(o1.getKey().getParamType());
            }
        });

        Map<HttpParameter, List<String>> sortedMap = new LinkedHashMap();
        for (Map.Entry<HttpParameter, List<String>> entry : list) {
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
