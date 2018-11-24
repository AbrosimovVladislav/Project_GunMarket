package com.gunmarket.repository.simpleRepo;

import java.util.List;

public interface ObjectSimpleRepo {

    List<Object> getAll(String entityName, Class entityClass);

}
