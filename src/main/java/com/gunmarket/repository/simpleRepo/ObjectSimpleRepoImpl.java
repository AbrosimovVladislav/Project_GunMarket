package com.gunmarket.repository.simpleRepo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObjectSimpleRepoImpl implements ObjectSimpleRepo {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void add(Object o) {
        Session session = currentSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Object getByParam(String paramName, String paramValue, String entityName, Class entityClass) {
        return currentSession()
                .createQuery("from " + entityName + " where " + paramName + " = :" + paramName)
                .setParameter(paramName, paramValue)
                .list().stream().findAny().orElse(null);
    }

    @Override
    public List getAll(String entityName, Class entityClass) {
        return currentSession()
                .createQuery("from " + entityName, entityClass)
                .list();
    }

}
