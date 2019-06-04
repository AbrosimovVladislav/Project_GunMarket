package pro.va.gunmarket.domain.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Map;


@Entity
@Component
@Getter
@Setter
public class Part extends Product {
	public static final String PART_COLOR = "color";
	public static final String PART_PARAMS = "params";

	@Column(name = PART_PARAMS)
	private Map<String,String> params;

	@Column(name = PART_COLOR)
	private String color;
}
