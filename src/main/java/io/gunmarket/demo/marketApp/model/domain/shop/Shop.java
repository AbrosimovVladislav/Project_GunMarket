package io.gunmarket.demo.marketApp.model.domain.shop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.gunmarket.demo.marketApp.model.domain.BasicEntity;
import io.gunmarket.demo.marketApp.model.domain.attributes.Address;
import io.gunmarket.demo.marketApp.model.domain.attributes.Rating;
import io.gunmarket.demo.marketApp.model.domain.attributes.Review;
import io.gunmarket.demo.marketApp.model.domain.offer.ProductInShop;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

import static io.gunmarket.demo.marketApp.model.domain.shop.Shop.SHOP_TABLE;


@Entity
@Table(name = SHOP_TABLE)
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Shop implements BasicEntity {
    public static final String SHOP_TABLE = "shop";
    public static final String SHOP_ID = "shopId";
    public static final String SHOP_NAME = "name";
    public static final String SHOP_ADDRESS = "address";
    public static final String SHOP_WEBSITE = "website";
    public static final String SHOP_INFO = "shopInfo";
    public static final String SHOP_RATING = "shopRating";
    public static final String SHOP_RATING_ID = "ratingId";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = SHOP_ID, length = 8, nullable = false)
    private Long shopId;

    @Column(name = SHOP_NAME, nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = SHOP_TABLE)
    private Set<Address> address;

    @Column(name = SHOP_WEBSITE, nullable = false)
    private String website;

    @Column(name = SHOP_INFO, length = 2000)
    private String shopInfo;

    @JsonIgnore
    @OneToMany(mappedBy = SHOP_TABLE)
    private Set<ProductInShop> product;

    @JsonIgnore
    @OneToMany(mappedBy = SHOP_TABLE)
    private Set<Review> review;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = SHOP_RATING_ID, referencedColumnName = SHOP_RATING_ID)
    private Rating rating;
}
