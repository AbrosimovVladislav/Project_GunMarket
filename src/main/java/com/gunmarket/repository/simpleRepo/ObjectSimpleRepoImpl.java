package com.gunmarket.repository.simpleRepo;

import javafx.util.Pair;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.gunmarket.web.ProductController.COMPLEX_PARAM_TYPE;
import static com.gunmarket.web.ProductController.OBJECTSIMPLE_PARAM_TYPE;

@Repository
public class ObjectSimpleRepoImpl implements ObjectSimpleRepo {

    private static final int AND_LENGTH = 5;
    private static final int OR_LENGTH = 4;
    private static int paramCounter = 0;

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    public List getByParamsDueHql(String entityName, Map<Pair<String, String>, List<String>> params) {
        Query query = currentSession().createQuery(createHqlGetByParamsQuery(entityName, params));
        int paramCounter = 0;
        for (List<String> values : params.values()) {
            for (String value : values) {
                query.setParameter("p" + value + paramCounter + "n", value);
                paramCounter++;
            }
        }

        System.out.println(query.getQueryString());
        return query.list();
    }

    //ToDo поправить модификаторы
    public static String createHqlGetByParamsQuery(String entityName, Map<Pair<String, String>, List<String>> params) {

        String resultHqlQuery = "";
        String connectorLine = ") AND " + entityName.toLowerCase() + "_Id IN (";

        for (Map.Entry<Pair<String, String>, List<String>> paramEntry : params.entrySet()) {
            String paramName = paramEntry.getKey().getKey();
            String paramType = paramEntry.getKey().getValue();
            List<String> paramValues = paramEntry.getValue();

            if (paramType.equals(COMPLEX_PARAM_TYPE)) {
                resultHqlQuery = getComlexParamQueryPart(entityName, paramName, paramValues, resultHqlQuery, connectorLine);
            } else {
                resultHqlQuery = getSimpleParamQueryPart(entityName, paramName, paramValues, resultHqlQuery, connectorLine, paramType);
            }
        }

        resultHqlQuery = resultHqlQuery.replaceFirst("\\)", "");
        return resultHqlQuery.substring(0, resultHqlQuery.length() - connectorLine.length() + 1);

    }

    private static String getComlexParamQueryPart(String entityName, String paramName, List<String> paramValues, String resultHqlQuery, String connectorLine) {
        String querySubject = entityName.toLowerCase() + "s";
        String fromParam = replaceLastChar(paramName);
        fromParam = firstUpperCase(fromParam);
        String newParamName = firstLowerCase(fromParam) + "_Id";
        String currentQPArt = "";
        currentQPArt = currentQPArt + "SELECT " + querySubject + " FROM " + fromParam + " WHERE ";
        for (String paramValue : paramValues) {
            currentQPArt = currentQPArt + newParamName + " = :p" + paramValue + paramCounter + "n OR ";
            paramCounter++;
        }
        // заменить на delete при работе со стрингБилдерами и будет норм работать
        currentQPArt = currentQPArt.replace(currentQPArt.substring(currentQPArt.length() - 4, currentQPArt.length() - 1), "");
        return resultHqlQuery + currentQPArt + connectorLine;
    }

    private static String getSimpleParamQueryPart(String entityName, String paramName, List<String> paramValues, String resultHqlQuery, String connectorLine, String paramType) {
        if (paramType.equals(OBJECTSIMPLE_PARAM_TYPE)) {
            paramName = paramName + "_id";
        }
        String currentQPArt = "";
        currentQPArt = currentQPArt + "FROM " + entityName + " WHERE ";
        for (String paramValue : paramValues) {
            currentQPArt = currentQPArt + paramName + " = :p" + paramValue + paramCounter + "n OR ";
            paramCounter++;
        }
        // заменить на delete при работе со стрингБилдерами и будет норм работать
        currentQPArt = currentQPArt.replace(currentQPArt.substring(currentQPArt.length() - 4, currentQPArt.length() - 1), "");
        return resultHqlQuery + currentQPArt + connectorLine;
    }

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
