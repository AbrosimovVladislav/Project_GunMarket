package io.gunmarket.demo.marketApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

import static io.gunmarket.demo.marketApp.domain.Shop.SHOP_TABLE;


@Entity
@Table(name = SHOP_TABLE)
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Shop {
    public static final String SHOP_TABLE = "shop";
    public static final String SHOP_ID = "shop_id";
    public static final String SHOP_NAME = "name";
    public static final String SHOP_ADDRESS = "address";
    public static final String SHOP_WEBSITE = "website";
    public static final String SHOP_INFO = "shopInfo";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = SHOP_ID, length = 8, nullable = false)
    private Long shopId;

    @Column(name = SHOP_NAME, nullable = false)
    private String name;

/*	@Column(name = SHOP_ADDRESS, nullable = false)
	private String address;*/

    @JsonIgnore
    @OneToMany(mappedBy = SHOP_TABLE)
    Set<Address> addresses;

    @Column(name = SHOP_WEBSITE, nullable = false)
    private String website;

    @Column(name = SHOP_INFO, length = 2000)
    private String shopInfo;

    @JsonIgnore
    @OneToMany(mappedBy = SHOP_TABLE)
    Set<ProductInShop> products;
}
