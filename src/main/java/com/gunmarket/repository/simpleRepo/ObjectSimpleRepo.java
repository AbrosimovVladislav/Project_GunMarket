package com.gunmarket.repository.simpleRepo;

import java.util.List;

public interface ObjectSimpleRepo {

    void add(Object o);

    Object getByParam(String paramName, String paramValue, String entityName, Class entityClass);

    List<Object> getAll(String entityName, Class entityClass);

}
