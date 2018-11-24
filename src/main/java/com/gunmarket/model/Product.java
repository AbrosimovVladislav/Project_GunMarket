package com.gunmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "price")
    private String price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="type_id", nullable=false)
    private Type type;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    private Set<Shop> shops;

    public Product() {
    }

    public Product(String name, String price, Type type, Set<Shop> shops) {
        this.name = name;
        this.price = price;
        this.type = type;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
                ", price='" + price + '\'' +
                ", type=" + type +
                ", shops=" + shops +
                '}';
    }

}
