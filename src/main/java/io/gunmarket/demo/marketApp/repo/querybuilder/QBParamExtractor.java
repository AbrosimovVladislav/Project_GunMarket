package io.gunmarket.demo.marketApp.repo.querybuilder;

import java.util.Arrays;
import java.util.List;


public class QBParamExtractor {
    private final List<String> entitiesAndLastIsParam;

    public QBParamExtractor(String paramKey) {
        this.entitiesAndLastIsParam = Arrays.asList(paramKey.split("."));
    }

    public QBParam extractQbParam(String paramValue) {
        return QBParam.builder()
                .paramName(defineParamName())
                .paramValue(paramValue)
                .operation(Operation.define(paramValue))
                .entities(defineEntities())
                .build();
    }

    private String defineParamName() {
        return entitiesAndLastIsParam.get(entitiesAndLastIsParam.size() - 1);
    }

    private List<String> defineEntities() {
        return entitiesAndLastIsParam.subList(0, entitiesAndLastIsParam.size() - 1);
    }
}
