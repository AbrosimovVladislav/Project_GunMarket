package com.gunmarket.repository.simpleRepo;

import java.util.List;
import java.util.Map;

public interface ObjectSimpleRepo {

    List getByParamsDueHql(String entityName, Map<String, List<String>> params);

}
