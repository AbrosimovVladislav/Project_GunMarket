package io.gunmarket.demo.marketApp.model.domain.offer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.gunmarket.demo.marketApp.model.domain.BasicEntity;
import io.gunmarket.demo.marketApp.model.domain.product.Product;
import io.gunmarket.demo.marketApp.model.domain.shop.Shop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static io.gunmarket.demo.marketApp.model.domain.offer.ProductInShop.PRODUCT_IN_SHOP_TABLE;
import static io.gunmarket.demo.marketApp.model.domain.product.Product.PRODUCT_ID;
import static io.gunmarket.demo.marketApp.model.domain.shop.Shop.SHOP_ID;

@Entity
@Table(name = PRODUCT_IN_SHOP_TABLE)
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductInShop implements BasicEntity {
    public static final String PRODUCT_IN_SHOP_ID = "productInShopId";
    public static final String PRODUCT_IN_SHOP_TABLE = "productInShop";
    public static final String PRODUCT_IN_SHOP_PRICE = "price";
    public static final String PRODUCT_IN_SHOP_SALE = "sale";
    public static final String PRODUCT_IN_SHOP_IN_STOCK = "inStock";
    public static final String PRODUCT_IN_SHOP_ADDITIONAL_INFO = "additionalInfo";
    public static final String PRODUCT_IN_SHOP_LINK = "link";
    public static final String PRODUCT_IN_SHOP_POPULARITY = "popularity";

    @Id
    @Column(name = PRODUCT_IN_SHOP_ID, nullable = false)
    private String productInShopId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = PRODUCT_ID, nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = SHOP_ID, nullable = false)
    private Shop shop;

    @Column(name = PRODUCT_IN_SHOP_PRICE, nullable = false)
    private double price;

    //ToDO выставить ограничение по скидке
    @Column(name = PRODUCT_IN_SHOP_SALE)
    private int sale;

    @Column(name = PRODUCT_IN_SHOP_IN_STOCK, nullable = false)
    private boolean inStock;

    @Column(name = PRODUCT_IN_SHOP_ADDITIONAL_INFO)
    private String additionalInfo;

    @Column(name = PRODUCT_IN_SHOP_LINK, nullable = false)
    private String link;

    @Min(0)
    @Max(1)
    @Column(name = PRODUCT_IN_SHOP_POPULARITY, nullable = false)
    private double popularity;

    @SuppressWarnings("unused")
    public ProductInShop(Product product, Shop shop, double price, boolean inStock, String link, int sale, double popularity) {
        this.productInShopId = product.getProductId() + ":" + shop.getShopId();
        this.product = product;
        this.shop = shop;
        this.price = price;
        this.inStock = inStock;
        this.link = link;
        this.sale = sale;
        this.popularity = popularity;
    }
}
