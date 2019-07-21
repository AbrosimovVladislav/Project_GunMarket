package io.gunmarket.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

import static io.gunmarket.demo.domain.Shop.SHOP_TABLE;


@Entity
@Table(name = SHOP_TABLE)
@Getter
@Setter
public class Shop {
	public static final String SHOP_TABLE = "shop";
	public static final String SHOP_ID = "shop_id";
	public static final String SHOP_NAME = "name";
	public static final String SHOP_ADDRESS = "address";
	public static final String SHOP_WEBSITE = "website";
	public static final String SHOP_DESCRIPTION = "description";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = SHOP_ID, length = 8, nullable = false)
	private Long shopId;

	@Column(name = SHOP_NAME, nullable = false)
	private String name;

	@Column(name = SHOP_ADDRESS, nullable = false)
	private String address;

	@Column(name = SHOP_WEBSITE, nullable = false)
	private String website;

	@Column(name = SHOP_DESCRIPTION)
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = SHOP_TABLE)
	Set<ProductInShop> products;
}
