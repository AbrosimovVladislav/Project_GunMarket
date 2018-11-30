package com.gunmarket.repository.simpleRepo;

import java.util.List;
import java.util.Map;

public interface ObjectSimpleRepo {

    List getAll(String entityName, Class entityClass);

    List getByParamsDueSql(String entityName, Map<String, List<String>> params);

    List getByParamsDueHql(String entityName, Map<String, List<String>> params);

}
