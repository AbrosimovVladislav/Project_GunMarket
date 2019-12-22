package io.gunmarket.demo.marketApp.domain;

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

import static io.gunmarket.demo.marketApp.domain.Caliber.CALIBER_TABLE;


@Entity
@Table(name = CALIBER_TABLE)
@Getter
@Setter
public class Caliber {
	public static final String CALIBER_TABLE = "caliber";
	public static final String CALIBER_ID = "caliber_id";
	public static final String CALIBER_VALUE = "value";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = CALIBER_ID, length = 8, nullable = false)
	private Long caliberId;

	@Column(name = CALIBER_VALUE)
	private String value;

	@JsonIgnore
	@OneToMany(mappedBy = CALIBER_TABLE)
	private Set<Product> product;
}
