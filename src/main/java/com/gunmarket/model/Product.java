package com.gunmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
@Component
public class Product {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "product_Id", length = 8, nullable = false)
    private long product_Id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    private Set<Shop> shops;

    public Product() {
    }

    public Product(String name, Set<Shop> shops) {
        this.name = name;
        this.shops = shops;
    }

    public long getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(long product_Id) {
        this.product_Id = product_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_Id=" + product_Id +
                ", name='" + name + '\'' +
                '}';
    }

}
