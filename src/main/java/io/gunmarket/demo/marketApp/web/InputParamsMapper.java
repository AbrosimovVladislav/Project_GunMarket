package io.gunmarket.demo.marketApp.web;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputParamsMapper {

    public static Set<RequestParameter> mapEntryParamsToRequestParams(Map<String,String> params, Map<String,Boolean> parameterTypes){
        return params.entrySet()
                .stream()
                .filter(param -> parameterTypes.containsKey(param.getKey()))
                .filter(param -> param.getValue() != null)
                .map(param -> new RequestParameter(
                        param.getKey(),
                        param.getValue(),
                        parameterTypes.get(param.getKey())
                ))
                .collect(Collectors.toSet());
    }

}
