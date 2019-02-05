package com.gunmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gunmarket.model.product.Product;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

import static com.gunmarket.model.product.Product.PRODUCT_MANUFACTURER;

@Entity
@Table(name = "manufacturer")
@Component
public class Manufacturer {

    public static final String MANUFACTURER_ID = "manufacturer_Id";
    private static final String MANUFACTURER_NAME = "manufacturer_name";
    public static final String MANUFACTURER_ENTITY = "manufacturer";

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = MANUFACTURER_ID, length = 8, nullable = false)
    private Long manufacturer_Id;

    @Column(name = MANUFACTURER_NAME)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = PRODUCT_MANUFACTURER)
    private Set<Product> products;

    public Manufacturer() {
    }

    public Manufacturer(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Long getManufacturer_Id() {
        return manufacturer_Id;
    }

    public void setManufacturer_Id(Long manufacturer_Id) {
        this.manufacturer_Id = manufacturer_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturer_Id=" + manufacturer_Id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
