package com.gunmarket.repository.simpleRepo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    public List getAll(String entityName, Class entityClass) {
        return currentSession()
                .createQuery("from " + entityName, entityClass)
                .list();
    }

    public List getByParams(String entityName, Class entityClass, Map<String, List<String>> params) {
        return currentSession()
                .createSQLQuery(createSqlQueryForGetByParams(entityName, params))
                .list();
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    private String createSqlQueryForGetByParams(String entityName, Map<String, List<String>> params) {
        StringBuilder sb = new StringBuilder("SELECT * FROM " + entityName + " WHERE ");
        for (Map.Entry<String, List<String>> entry : params.entrySet()) {
            sb.append("(");
            for (String paramValue : entry.getValue()) {
                sb.append(entry.getKey()).append(" = '").append(paramValue).append("' OR ");
            }
            sb.delete(sb.length() - OR_LENGTH, sb.length() - 1);
            sb.append(") AND ");
        }

        return sb.delete(sb.length() - AND_LENGTH, sb.length() - 1).toString();
    }

    //SELECT * FROM Product WHERE price = '350' OR price = '400' AND type_id = '1' OR type_id = '2'

}
