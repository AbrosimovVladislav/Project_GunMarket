package com.gunmarket.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

import static com.gunmarket.model.Product.PRODUCT_TYPE;

@Entity
@Table(name = "type")
@Component
public class Type {

    public static final String TYPE_ID = "type_Id";
    public static final String TYPE_NAME = "name";

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = TYPE_ID, length = 8, nullable = false)
    private long type_Id;

    @Column(name = TYPE_NAME)
    private String name;

    @OneToMany(mappedBy=PRODUCT_TYPE)
    private Set<Product> products;

    public Type() {
    }

    public Type(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public long getType_Id() {
        return type_Id;
    }

    public void setType_Id(long type_Id) {
        this.type_Id = type_Id;
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
        return "Type{" +
                "type_Id=" + type_Id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
