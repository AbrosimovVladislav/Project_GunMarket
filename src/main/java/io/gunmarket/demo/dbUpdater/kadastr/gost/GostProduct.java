package io.gunmarket.demo.dbUpdater.kadastr.gost;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GostProduct {

	private String gostInternalId;
	private String name;
	private String brand;
	private String technicalIndicators;

	public GostProduct(String gostInternalId, String name, String brand, String technicalIndicators) {
		this.gostInternalId = gostInternalId;
		this.name = name;
		this.brand = brand;
		this.technicalIndicators = technicalIndicators;
	}

}

/*
4.2/51
Патрон пистолетный спор-тивный «9mm Luger» (9х19мм) с экспансивной пулей Россия,
ОАО»Тульский патронный завод».г.Тула
ТУ 7272-080-08629358-05
■■ Калибр 9 мм■Длина патрона 27,34-27,86 мм■Масса патрона 11,14-11,77г■Масса пули: 7,41-7,69г■Патроны снаряжаются пулей с пустым (полым) наконечником.■Гильза –сталь■ Патроны ПЭП 9х19.000 снаряжают-ся пулей с латунной оболочкой,■ПЭП 9х19.000-01 с бим
 */
