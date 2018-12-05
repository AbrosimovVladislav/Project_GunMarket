package com.gunmarket.repository.simpleRepo;

import com.gunmarket.repository.QueryBuilder;
import javafx.util.Pair;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ObjectSimpleRepoImpl implements ObjectSimpleRepo {

    @Autowired
    private SessionFactory sessionFactory;

    private QueryBuilder queryBuilder = new QueryBuilder();

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    public List getByParamsDueHql(String entityName, Map<Pair<String, String>, List<String>> params) {
        Query query = currentSession().createQuery(queryBuilder.build(entityName, params));
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

}
