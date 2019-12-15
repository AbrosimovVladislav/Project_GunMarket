package io.gunmarket.demo.marketApp.repo.querybuilder;

public enum Operation {
    EQUALS, IN, BETWEEN;

    public static Operation define(String paramValue) {
        if (paramValue.contains(",")) return IN;
        else if (paramValue.contains("interval")) return BETWEEN;
        else return EQUALS;
    }
}
