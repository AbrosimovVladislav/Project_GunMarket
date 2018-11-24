package com.gunmarket.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "type")
@Component
public class Type {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "type_Id", length = 8, nullable = false)
    private long type_Id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="type")
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