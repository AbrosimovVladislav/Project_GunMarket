package com.gunmarket.model.product;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Component
public class Ammo extends Product {

    public static final String AMMO_CALIBER = "ammo_caliber";

    @Column(name = AMMO_CALIBER)
    private String caliber;

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }
}
