package com.gunmarket.model.product;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Component
public class Part extends Product {

    public static final String PART_ENTITY = "Part";
    public static final String PART_SUBCATEGORY = "part_subcategory";
    public static final String PART_FAMILY = "part_family";
    public static final String PART_INNER_OR_OUTER = "part_inner_or_outer";

    @Column(name = PART_SUBCATEGORY)
    private String subcategory;

    @Column(name = PART_FAMILY)
    private String family;

    @Column(name = PART_INNER_OR_OUTER)
    private String innerOrOuter;

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getInnerOrOuter() {
        return innerOrOuter;
    }

    public void setInnerOrOuter(String innerOrOuter) {
        this.innerOrOuter = innerOrOuter;
    }
}
