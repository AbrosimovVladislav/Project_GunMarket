package com.gunmarket.repository.simpleRepo;

import com.gunmarket.repository.QueryBuilder;
import com.gunmarket.web.HttpParameter;
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

    private static int paramRepoCounter = 0;

    private QueryBuilder queryBuilder = new QueryBuilder();

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    public List getByParamsDueHql(String entityName, Map<HttpParameter, List<String>> params) {
        Query query = currentSession().createQuery(queryBuilder.build(entityName, params));
        for (Map.Entry<HttpParameter, List<String>> entry : params.entrySet()) {
            for (String value : entry.getValue()) {
                String paramClass = entry.getKey().getParamClass();
                query.setParameter("p" + value + paramRepoCounter + "n",
                        paramClass.equals("Long") ? Long.valueOf(value) : value);
                paramRepoCounter++;
            }
        }

        //ToDo Удалить вывод
        System.out.println("Вывод итогового запроса " + query.getQueryString());
        return query.list();
    }

}
