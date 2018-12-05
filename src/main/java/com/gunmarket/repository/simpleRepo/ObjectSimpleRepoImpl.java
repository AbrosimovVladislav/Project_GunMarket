package com.gunmarket.repository.simpleRepo;

import javafx.util.Pair;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.gunmarket.web.ProductController.COMPLEX_PARAM_TYPE;
import static com.gunmarket.web.ProductController.OBJECTSIMPLE_PARAM_TYPE;
import static com.gunmarket.web.ProductController.SIMPLE_PARAM_TYPE;

@Repository
public class ObjectSimpleRepoImpl implements ObjectSimpleRepo {

    private static final int AND_LENGTH = 5;
    private static final int OR_LENGTH = 4;

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    /*
    SELECT p.product_Id, p.name, p.price FROM product AS
    WHERE p.price = 400 AND type_id =1
    AND p.product_Id IN (SELECT p.product_Id FROM shop AS s
            JOIN shop_product AS sp ON s.shop_Id = sp.shop_Id
            JOIN product AS p ON p.product_Id = sp.product_id
            WHERE s.shop_Id = 2 OR s.shop_Id = 3);
     */

    public List getByParamsDueHql(String entityName, Map<Pair<String,String>, List<String>> params) {
        Query query = currentSession().createQuery(createHqlGetByParamsQuery(entityName,params));
        /*int paramCounter = 0;
        for (List<String> values : params.values()) {
            for (String value : values) {
                query.setParameter("p" + value + paramCounter + "n", value);
                paramCounter++;
            }
        }*/

        System.out.println(query.getQueryString());
        return query.list();
    }

    //ToDo поправить модификаторы
    public static String createHqlGetByParamsQuery(String entityName, Map<Pair<String,String>, List<String>> params) {
        /*
        SELECT * FROM product AS p WHERE type_id = 1
AND p.product_Id IN
  (SELECT p.product_Id FROM shop AS s
JOIN shop_product AS sp ON s.shop_Id = sp.shop_Id
JOIN product AS p ON p.product_Id = sp.product_id
WHERE s.shop_Id = 2 OR s.shop_Id = 3)
AND p.product_Id IN
  (SELECT p.product_Id FROM product AS p
WHERE price > 350);
         */

        String resultHqlQuery = "";
        int paramCounter = 0;
        String connectorLine = "AND " + entityName.toLowerCase() + "_Id IN (";

        //можноу простить сведением simple и objectSimple в одно подусловие
        for (Map.Entry<Pair<String,String>, List<String>> paramEntry : params.entrySet()) {
            String paramName = paramEntry.getKey().getKey();
            String paramType = paramEntry.getKey().getValue();
            List<String> paramValues = paramEntry.getValue();
            String currentQPArt = "";
            if(paramType.equals(SIMPLE_PARAM_TYPE)){
                currentQPArt = currentQPArt + "FROM " + entityName + " WHERE ";
                for (String paramValue : paramValues) {
                    currentQPArt = currentQPArt + paramName + " = :p" + paramValue + paramCounter + "n OR ";
                    paramCounter++;
                }
                currentQPArt = currentQPArt.replace(currentQPArt.substring(currentQPArt.length()-4,currentQPArt.length()-1),"");
                resultHqlQuery = resultHqlQuery + currentQPArt + connectorLine;
            } else if(paramType.equals(OBJECTSIMPLE_PARAM_TYPE)){
                paramName = paramName + "_id";
                currentQPArt = currentQPArt + "FROM " + entityName + " WHERE ";
                for (String paramValue : paramValues) {
                    currentQPArt = currentQPArt + paramName + " = :p" + paramValue + paramCounter + "n OR ";
                    paramCounter++;
                }
                currentQPArt = currentQPArt.replace(currentQPArt.substring(currentQPArt.length()-4,currentQPArt.length()-1),"");
                resultHqlQuery = resultHqlQuery + currentQPArt + connectorLine;
            } else if(paramType.equals(COMPLEX_PARAM_TYPE)){
                String querySubject = entityName.toLowerCase() + "s";
                String fromParam = replaceLastChar(paramName);
                fromParam = firstUpperCase(fromParam);
                String newParamName = firstLowerCase(fromParam) + "_Id";
                currentQPArt = currentQPArt + "SELECT "+ querySubject + " FROM " + fromParam + " WHERE ";
                for (String paramValue : paramValues) {
                    currentQPArt = currentQPArt + newParamName + " = :p" + paramValue + paramCounter + "n OR ";
                    paramCounter++;
                }
                currentQPArt = currentQPArt.replace(currentQPArt.substring(currentQPArt.length()-4,currentQPArt.length()-1),"");
                resultHqlQuery = resultHqlQuery + currentQPArt + connectorLine;
            }
        }

        return resultHqlQuery;

    }

    public static String replaceLastChar(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public static String firstLowerCase(String word){
        if(word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toLowerCase() + word.substring(1);
    }

    /*        //ИЗ entityName ГДE параметр =:параметр
        String simpleParamQuery = "FROM Product AS p WHERE p.id =1";
        //ИЗ entityName ГДE параметр + ".id" =:параметр
        String simpleObjectparamQuery = "FROM Product AS p WHERE type.id = 1";
        //ВЫБОР entityName(LowerCase + s) ИЗ параметр(Первая буква UpperCase)
        // ГДЕ параметр(Первая буква UpperCase).id = :параметр
        String complexParamQuery = "SELECT products FROM Shop WHERE Shop.name = 'Levsha' OR Shop.name = 'OrDvor'";

        String hqlQuery = simpleObjectparamQuery;

        return hqlQuery;*/

    /*
    private String createHqlGetByParamsQuery(String entityName, Map<String, List<String>> params) {
        String sqlQuery = "FROM " + entityName + " WHERE ";
        int paramCounter = 0;
        StringBuilder sb = new StringBuilder(sqlQuery);
        for (Map.Entry<String, List<String>> entry : params.entrySet()) {
            sb.append("(");
            for (String paramValue : entry.getValue()) {
                sb.append(entry.getKey()).append(" = :p").append(paramValue).append(paramCounter).append("n OR ");
                paramCounter++;
            }
            sb.delete(sb.length() - 4, sb.length() - 1);
            sb.append(") AND ");
        }

        return sb.delete(sb.length() - 5, sb.length() - 1).toString();
    }

    public List getByParamsDueHql(String entityName, Map<String, List<String>> params) {
        Query query = currentSession().createQuery(createHqlGetByParamsQuery(entityName, params));
        int paramCounter = 0;
        for (List<String> values : params.values()) {
            for (String value : values) {
                query.setParameter("p" + value + +paramCounter + "n", value);
                paramCounter++;
            }
        }

        System.out.println(query.getQueryString());
        return query.list();
    }

    */

}
