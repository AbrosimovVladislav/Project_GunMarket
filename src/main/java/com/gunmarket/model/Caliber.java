package com.gunmarket.model;

import com.gunmarket.model.product.Product;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

import static com.gunmarket.model.product.Product.PRODUCT_CALIBER;

@Entity
@Table(name = "caliber")
@Component
public class Caliber {

    public static final String CALIBER_ID = "caliber_Id";
    private static final String CALIBER_VALUE = "caliber_value";
    public static final String CALIBER_ENTITY = "caliber";

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = CALIBER_ID, length = 8, nullable = false)
    private Long caliber_Id;

    @Column(name = CALIBER_VALUE)
    private String name;

    @OneToMany(mappedBy = PRODUCT_CALIBER)
    private Set<Product> products;

    public Caliber() {
    }

    public Caliber(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Long getCaliber_Id() {
        return caliber_Id;
    }

    public void setCaliber_Id(Long caliber_Id) {
        this.caliber_Id = caliber_Id;
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
        return "Caliber{" +
                "caliber_Id=" + caliber_Id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
