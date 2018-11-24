package com.gunmarket.repository.simpleRepo;

import com.gunmarket.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObjectSimpleRepoImpl implements ObjectSimpleRepo {

    @Autowired
    private HibernateTemplate template;

    private HibernateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public List getAll(Class entityClass) {
        return getTemplate().loadAll(entityClass);
    }

}
