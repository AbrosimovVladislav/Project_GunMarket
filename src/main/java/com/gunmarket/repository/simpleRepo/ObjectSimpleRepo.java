package com.gunmarket.repository.simpleRepo;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public interface ObjectSimpleRepo {

    List getByParamsDueHql(String entityName, Map<Pair<String,String>, List<String>> params);

}
