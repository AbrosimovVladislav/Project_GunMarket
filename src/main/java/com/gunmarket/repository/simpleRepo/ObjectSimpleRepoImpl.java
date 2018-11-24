package com.gunmarket.repository.simpleRepo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObjectSimpleRepoImpl implements ObjectSimpleRepo {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    public List getAll(String entityName, Class entityClass) {
        return currentSession()
                .createQuery("from " + entityName, entityClass)
                .list();
    }

}
