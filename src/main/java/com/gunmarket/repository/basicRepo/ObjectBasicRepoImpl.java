package com.gunmarket.repository.basicRepo;

import com.gunmarket.model.BasicEntity;
import com.gunmarket.repository.basicRepo.queryBuilder.QueryBuilder;
import com.gunmarket.web.webEntity.HttpParameter;
import com.gunmarket.web.webEntity.ParameterValue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.gunmarket.repository.basicRepo.repoUtils.RepoUtils.addMarkersToParams;

@Repository
public class ObjectBasicRepoImpl implements ObjectBasicRepo {

    @Autowired
    private SessionFactory sessionFactory;

    private QueryBuilder queryBuilder = new QueryBuilder();

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    public List<BasicEntity> getByParamsDueHql(String entityName, Map<HttpParameter, List<String>> params) {
        Map<HttpParameter, List<ParameterValue>> markedparams = addMarkersToParams(params);
        Query<BasicEntity> query = currentSession().createQuery(queryBuilder.build(entityName, markedparams));

        markedparams.forEach((httpParameter, parameterValues) ->
                parameterValues.forEach(parameterValue ->
                        query.setParameter(
                                parameterValue.getValueMarker().replaceFirst(":", "")
                                , httpParameter.getParamClass().equals("Long")
                                        ? Long.valueOf(parameterValue.getValue())
                                        : parameterValue.getValue())));

        //ToDo Удалить вывод
        System.out.println("Вывод итогового запроса " + query.getQueryString());
        return query.list();
    }

}
