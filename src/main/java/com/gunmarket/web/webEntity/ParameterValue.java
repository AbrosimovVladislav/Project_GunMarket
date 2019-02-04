package com.gunmarket.web.webEntity;

import java.util.Random;

public class ParameterValue {

    private String value;
    private String valueMarker;

    public ParameterValue(String value) {
        this.value = value;
        this.valueMarker = getRandomMarker();
    }

    private String getRandomMarker() {
        Random random = new Random();
        return ":p" + (Math.abs(random.nextLong() * random.nextInt())) + "v";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueMarker() {
        return valueMarker;
    }

    public void setValueMarker(String valueMarker) {
        this.valueMarker = valueMarker;
    }

}
