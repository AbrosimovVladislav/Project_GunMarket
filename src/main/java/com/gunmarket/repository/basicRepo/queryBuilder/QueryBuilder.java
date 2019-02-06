package com.gunmarket.repository.basicRepo.queryBuilder;

import com.gunmarket.web.webEntity.HttpParameter;
import com.gunmarket.web.webEntity.ParameterValue;

import java.util.List;
import java.util.Map;

import static com.gunmarket.repository.basicRepo.repoUtils.RepoUtils.firstUpperCase;
import static com.gunmarket.repository.basicRepo.repoUtils.RepoUtils.replaceLastChar;
import static com.gunmarket.service.ProductService.PRODUCT_ENTITY;
import static com.gunmarket.web.webEntity.HttpParameter.COMPLEX_PARAM_TYPE;
import static com.gunmarket.web.webEntity.HttpParameter.OBJECTSIMPLE_PARAM_TYPE;

public class QueryBuilder {

    private static final String EQUALLY_KEYWORD = " = ";
    private static final String OR_KEYWORD = " OR ";
    private static final String SELECT_KEYWORD = "SELECT ";
    private static final String FROM_KEYWORD = "FROM ";
    private static final String WHERE_KEYWORD = " WHERE ";
    private static final String IN_KEYWORD = " IN ";
    private static final String AND_KEYWORD = " AND ";
    private static final String AS_KEYWORD = " AS ";
    private static final String LEFT_JOIN_KEYWORD = " LEFT JOIN ";
    private static final String ID_LOWER_PARAMETER_ADDITION = "_id";
    private static final String ID_UPPER_PARAMETER_ADDITION = "_Id";
    private static final String PLURAL_ENDING_S = "s";
    private static final String COMMA = ".";
    private static final String SPACE = " ";
    private static final String CLOSING_BRACKET_REGEX = "\\)";
    private static final String CLOSING_BRACKET = ")";
    private static final String OPENING_BRACKET = "(";

    public String build(String entityName, Map<HttpParameter, List<ParameterValue>> params) {

        //Todo Работает не верно, не учитывает тип контроллера. При вызове у products , отдаст все товары.
        if (params.isEmpty()) {
            return FROM_KEYWORD + entityName;
        }

        String subqueriesConnectionLine = createSubqueriesConnectionLine(entityName);
        String resultHqlQuery = initResultQuery(entityName, params.keySet().iterator().next().getEntityClass(), subqueriesConnectionLine);

        for (Map.Entry<HttpParameter, List<ParameterValue>> paramEntry : params.entrySet()) {
            String paramName = paramEntry.getKey().getParamName();
            String paramType = paramEntry.getKey().getParamType();
            List<ParameterValue> paramValues = paramEntry.getValue();

            if (paramType.equals(COMPLEX_PARAM_TYPE)) {
                resultHqlQuery = getComplexParamQueryPart(entityName, paramName, paramValues, resultHqlQuery, subqueriesConnectionLine);
            } else {
                resultHqlQuery = getSimpleParamQueryPart(entityName, paramName, paramValues, resultHqlQuery, subqueriesConnectionLine, paramType);
            }
        }

        resultHqlQuery = resultHqlQuery.replaceFirst(CLOSING_BRACKET_REGEX, "");
        return resultHqlQuery.substring(0, resultHqlQuery.length() - subqueriesConnectionLine.length() + 1);

    }

    //Построение простой части
    private String getSimpleParamQueryPart(String entityName, String paramName, List<ParameterValue> paramValues, String resultHqlQuery, String connectorLine, String paramType) {
        if (paramType.equals(OBJECTSIMPLE_PARAM_TYPE)) {
            paramName = paramName + ID_LOWER_PARAMETER_ADDITION;
        }
        return createCleaningPartOfQuery(resultHqlQuery,
                createInitialPartOfSimpleParamQuery(entityName)
                        .append(createParamFillingPartOfSimpleParamQuery(entityName, paramName, paramValues)),
                connectorLine);
    }

    private StringBuilder createInitialPartOfSimpleParamQuery(String entityName) {
        return new StringBuilder(FROM_KEYWORD)
                .append(entityName)
                .append(WHERE_KEYWORD)
                .append(OPENING_BRACKET);
    }

    private String createParamFillingPartOfSimpleParamQuery(String entityName, String paramName, List<ParameterValue> paramValues) {
        StringBuilder currentQPArt = new StringBuilder();

        paramValues.forEach(paramValue -> currentQPArt.append(paramName)
                .append(EQUALLY_KEYWORD)
                .append(paramValue.getValueMarker())
                .append(OR_KEYWORD));

        return currentQPArt.append(CLOSING_BRACKET).toString();
    }

    //Построение составной части
    private String getComplexParamQueryPart(String entityName, String paramName, List<ParameterValue> paramValues, String resultHqlQuery, String connectorLine) {
        return createCleaningPartOfQuery(resultHqlQuery,
                createInitialPartOfComplexParamQuery(entityName, paramName)
                        .append(createParamFillingPartOfComplexParamQuery(paramName, paramValues)),
                connectorLine);
    }

    private StringBuilder createInitialPartOfComplexParamQuery(String entityName, String paramName) {
        return new StringBuilder(SELECT_KEYWORD)
                .append(entityName)
                .append(PLURAL_ENDING_S)
                .append(COMMA)
                .append(entityName.toLowerCase())
                .append(ID_UPPER_PARAMETER_ADDITION)
                .append(SPACE)
                .append(FROM_KEYWORD)
                .append(SPACE)
                .append(firstUpperCase(replaceLastChar(paramName)))
                .append(AS_KEYWORD)
                .append(firstUpperCase(replaceLastChar(paramName)))
                .append(LEFT_JOIN_KEYWORD)
                .append(firstUpperCase(replaceLastChar(paramName)))
                .append(COMMA)
                .append(entityName.toLowerCase())
                .append(PLURAL_ENDING_S)
                .append(SPACE)
                .append(entityName)
                .append(PLURAL_ENDING_S)
                .append(WHERE_KEYWORD); //SELECT Products.product_Id FROM Shop AS Shop LEFT JOIN Shop.products Products WHERE
    }

    private String createParamFillingPartOfComplexParamQuery(String paramName, List<ParameterValue> paramValues) {
        StringBuilder currentQPArt = new StringBuilder();

        paramValues.forEach(paramValue -> currentQPArt
                .append(firstUpperCase(replaceLastChar(paramName))) // Shop
                .append(COMMA) // .
                .append(replaceLastChar(paramName)) // shop
                .append(ID_UPPER_PARAMETER_ADDITION) // _Id
                .append(EQUALLY_KEYWORD) // =
                .append(paramValue.getValueMarker())
                .append(OR_KEYWORD));

        return currentQPArt.toString();
    }

    private String initResultQuery(String entityName, String entityClass, String connectorLine) {
        return entityName.equals(PRODUCT_ENTITY)
                ? FROM_KEYWORD + entityName + WHERE_KEYWORD + "DTYPE = " + entityClass + connectorLine
                : "";
    }

    /**
     * preparing the current subquery to connect with the following parts
     * --(common method for all types of parameters)--
     *
     * @param resultQuery   - resultQuery
     * @param currentQPArt  - currentQueryPart
     * @param connectorLine - line for subqueries connection
     * @return - String
     */
    private String createCleaningPartOfQuery(String resultQuery, StringBuilder currentQPArt, String connectorLine) {
        return resultQuery +
                currentQPArt.delete(currentQPArt.length() - 4, currentQPArt.length() - 1).toString() +
                connectorLine;
    }


    /**
     * line for subqueries connection
     * --(common method for all types of parameters)--
     * in result we have : ") AND entity_Id IN ("
     *
     * @param entityName - entityName
     * @return - String
     */
    private String createSubqueriesConnectionLine(String entityName) {
        return CLOSING_BRACKET + //)
                AND_KEYWORD + // AND
                entityName.toLowerCase() +// product
                ID_UPPER_PARAMETER_ADDITION + // _Id
                IN_KEYWORD + // IN
                OPENING_BRACKET;
    }

}
