package com.gunmarket.repository.basicRepo;

import com.gunmarket.web.HttpParameter;

import java.util.List;
import java.util.Map;

public interface ObjectBasicRepo {

    List getByParamsDueHql(String entityName, Map<HttpParameter, List<String>> params);

}
