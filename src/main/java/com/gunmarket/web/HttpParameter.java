package com.gunmarket.web;

import java.util.Objects;

public class HttpParameter {

    public static final String SIMPLE_PARAM_TYPE = "Simple";
    public static final String OBJECTSIMPLE_PARAM_TYPE = "ObjectSimple";
    public static final String COMPLEX_PARAM_TYPE = "Complex";
    public static final String PARAM_CLASS_LONG = "Long";
    public static final String PARAM_CLASS_STRING = "String";

    private String paramName;
    private String paramType;
    private String paramClass;

    public HttpParameter(String paramName, String paramType, String paramClass) {
        this.paramName = paramName;
        this.paramType = paramType;
        this.paramClass = paramClass;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamClass() {
        return paramClass;
    }

    public void setParamClass(String paramClass) {
        this.paramClass = paramClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpParameter that = (HttpParameter) o;
        return Objects.equals(paramName, that.paramName) &&
                Objects.equals(paramType, that.paramType) &&
                Objects.equals(paramClass, that.paramClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paramName, paramType, paramClass);
    }
}
