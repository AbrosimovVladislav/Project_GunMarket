package com.gunmarket.repository.simpleRepo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ObjectSimpleRepoImpl implements ObjectSimpleRepo {

    private static final int AND_LENGTH = 5;
    private static final int OR_LENGTH = 4;

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.openSession();
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

}
