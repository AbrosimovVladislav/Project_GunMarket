package io.gunmarket.demo.marketApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static io.gunmarket.demo.marketApp.domain.Address.ADDRESS_TABLE;
import static io.gunmarket.demo.marketApp.domain.Shop.SHOP_ID;

@Entity
@Table(name = ADDRESS_TABLE)
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {

    public static final String ADDRESS_TABLE = "address";
    public static final String ADDRESS_ID = "address_id";
    public static final String ADDRESS_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ADDRESS_ID, length = 8, nullable = false)
    private Long addressId;

    @Column(name = ADDRESS_NAME, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = SHOP_ID)
    private Shop shop;

}
