package com.gunmarket.repository;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;

import static com.gunmarket.web.ProductController.COMPLEX_PARAM_TYPE;
import static com.gunmarket.web.ProductController.OBJECTSIMPLE_PARAM_TYPE;

public class QueryBuilder {

    private static int paramCounter = 0;

    public String build(String entityName, Map<Pair<String, String>, List<String>> params) {

        String resultHqlQuery = "";
        String connectorLine = ") AND " + entityName.toLowerCase() + "_Id IN (";

        for (Map.Entry<Pair<String, String>, List<String>> paramEntry : params.entrySet()) {
            String paramName = paramEntry.getKey().getKey();
            String paramType = paramEntry.getKey().getValue();
            List<String> paramValues = paramEntry.getValue();

            if (paramType.equals(COMPLEX_PARAM_TYPE)) {
                resultHqlQuery = getComplexParamQueryPart(entityName, paramName, paramValues, resultHqlQuery, connectorLine);
            } else {
                resultHqlQuery = getSimpleParamQueryPart(entityName, paramName, paramValues, resultHqlQuery, connectorLine, paramType);
            }
        }

        resultHqlQuery = resultHqlQuery.replaceFirst("\\)", "");
        return resultHqlQuery.substring(0, resultHqlQuery.length() - connectorLine.length() + 1);

    }

    //Построение простой части
    private String getSimpleParamQueryPart(String entityName, String paramName, List<String> paramValues, String resultHqlQuery, String connectorLine, String paramType) {
        if (paramType.equals(OBJECTSIMPLE_PARAM_TYPE)) {
            paramName = paramName + "_id";
        }
        return createCleaningPartOfSimpleParamQuery(resultHqlQuery,
                createInitialPartOfSimpleParamQuery(entityName)
                        .append(createParamFillingPartOfSimpleParamQuery(paramName, paramValues)),
                connectorLine);
    }

    private StringBuilder createInitialPartOfSimpleParamQuery(String entityName) {
        return new StringBuilder("FROM ")
                .append(entityName)
                .append(" WHERE ");
    }

    private String createParamFillingPartOfSimpleParamQuery(String paramName, List<String> paramValues) {
        StringBuilder currentQPArt = new StringBuilder();
        for (String paramValue : paramValues) {
            currentQPArt
                    .append(paramName)
                    .append(" = :p")
                    .append(paramValue)
                    .append(paramCounter)
                    .append("n OR ");
            paramCounter++;
        }
        return currentQPArt.toString();
    }

    private String createCleaningPartOfSimpleParamQuery(String resultQuery, StringBuilder currentQPArt, String connectorLine) {
        return resultQuery +
                currentQPArt.delete(currentQPArt.length() - 4, currentQPArt.length() - 1).toString() +
                connectorLine;
    }

    //Построение составной части
    private String getComplexParamQueryPart(String entityName, String paramName, List<String> paramValues, String resultHqlQuery, String connectorLine) {
        return createCleaningPartOfComplexParamQuery(resultHqlQuery,
                createInitialPartOfComplexParamQuery(entityName, paramName)
                        .append(createParamFillingPartOfComplexParamQuery(paramName, paramValues)),
                connectorLine);
    }

    private StringBuilder createInitialPartOfComplexParamQuery(String entityName, String paramName) {
        return new StringBuilder("SELECT ")
                .append(entityName.toLowerCase())
                .append("s")
                .append(" FROM ")
                .append(firstUpperCase(replaceLastChar(paramName)))
                .append(" WHERE ");
    }

    private String createParamFillingPartOfComplexParamQuery(String paramName, List<String> paramValues) {
        StringBuilder currentQPArt = new StringBuilder();
        for (String paramValue : paramValues) {
            currentQPArt
                    .append(firstLowerCase(firstUpperCase(replaceLastChar(paramName))))
                    .append("_Id")
                    .append(" = :p")
                    .append(paramValue)
                    .append(paramCounter)
                    .append("n OR ");
            paramCounter++;
        }
        return currentQPArt.toString();
    }

    private String createCleaningPartOfComplexParamQuery(String resultQuery, StringBuilder currentQPArt, String connectorLine) {
        return resultQuery +
                currentQPArt.delete(currentQPArt.length() - 4, currentQPArt.length() - 1).toString() +
                connectorLine;
    }

    //Статические методы
    private static String replaceLastChar(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    private static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    private static String firstLowerCase(String word) {
        if (word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toLowerCase() + word.substring(1);
    }

}
