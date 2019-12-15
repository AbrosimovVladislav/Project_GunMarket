package io.gunmarket.demo.marketApp.repo.querybuilder;

import lombok.Builder;

import java.util.List;


@Builder
public class QBParam {
    String paramName;
    String paramValue;
    Operation operation;
    List<String> entities;
}