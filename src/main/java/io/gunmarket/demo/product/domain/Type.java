package io.gunmarket.demo.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gunmarket.demo.product.domain.product.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

import static io.gunmarket.demo.product.domain.Type.TYPE_TABLE;


@Entity
@Table(name = TYPE_TABLE)
@Getter
@Setter
@ToString(exclude = {"products"})
public class Type {
	public static final String TYPE_TABLE = "type";
	public static final String TYPE_ID = "type_id";
	public static final String TYPE_NAME = "name";
	public static final String TYPE_UPPER = "upper";
	public static final String TYPE_MEDIUM = "medium";
	public static final String TYPE_LOWER = "lower";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = TYPE_ID, length = 8, nullable = false)
	private Long typeId;

	@Column(name = TYPE_UPPER)
	private String upper;

	@Column(name = TYPE_MEDIUM)
	private String medium;

	@Column(name = TYPE_LOWER)
	private String lower;

	@JsonIgnore
	@OneToMany(mappedBy = TYPE_TABLE)
	private Set<Product> products;
}
