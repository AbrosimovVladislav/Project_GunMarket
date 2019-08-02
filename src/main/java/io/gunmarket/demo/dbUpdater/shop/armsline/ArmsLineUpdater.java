package io.gunmarket.demo.dbUpdater.shop.armsline;

import io.gunmarket.demo.dbUpdater.mapper.ProductInShopMapper;
import io.gunmarket.demo.product.domain.ProductInShop;
import io.gunmarket.demo.product.repo.ProductInShopRepo;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ArmsLineUpdater {

	private static final String ARMSLINE_MAIN_PAGE = "http://armsline.ru";
	private static final String item1 = ARMSLINE_MAIN_PAGE + "/s/43/oruzhie_samooborony.html";
	private static final String item2 = ARMSLINE_MAIN_PAGE + "/s/757/trawmaticheskoe_oruzhie.html";
	private static final String item3 = ARMSLINE_MAIN_PAGE + "/s/263/sredstwa_samooborony_bez_litsenzii.html";
	private static final String item4 = ARMSLINE_MAIN_PAGE + "/s/44/gladkostwolynoe_oruzhie.html";
	private static final String item5 = ARMSLINE_MAIN_PAGE + "/s/45/nareznoe_oruzhie.html";
	private static final String item6 = ARMSLINE_MAIN_PAGE + "/s/1062/eksklyuziwnoe_oruzhie.html";
	private static final String item7 = ARMSLINE_MAIN_PAGE + "/s/742/komissionnoe_oruzhie.html";
	private static final String item8 = ARMSLINE_MAIN_PAGE + "/s/389/makety_i_oholoschennoe.html";
	private static final String item9 = ARMSLINE_MAIN_PAGE + "/s/19/patrony.html";
	private static final String item0 = ARMSLINE_MAIN_PAGE + "/s/1249/aksessuary_dlya_oruzhiya.html";

	private final ArmsLineParser armsLineParser;
	private final ProductInShopRepo productInShopRepo;
	private final ProductInShopMapper productInShopMapper;

	public ArmsLineUpdater(ArmsLineParser armsLineParser,
	                       ProductInShopRepo productInShopRepo,
	                       ProductInShopMapper productInShopMapper) {
		this.armsLineParser = armsLineParser;
		this.productInShopRepo = productInShopRepo;
		this.productInShopMapper = productInShopMapper;
	}

	public List<ProductInShop> updateArmsLineContent() {
		Map<String, String> categories = new HashMap<>() {{
			put(item1, "cat1");
			put(item2, "cat1");
			put(item3, "cat1");
			put(item4, "cat1");
			put(item5, "cat1");
			put(item6, "cat1");
			put(item7, "cat1");
			put(item8, "cat1");
			put(item9, "cat1");
			put(item0, "cat1");
		}};

		Set<ArmsLineProduct> armsLineProducts = categories.entrySet()
				.stream()
				.map(e -> armsLineParser.getProductsFromCategory(e.getKey(), e.getValue()))
				.flatMap(Collection::stream)
				.collect(Collectors.toSet());

		List<ProductInShop> productInShops = productInShopMapper.fromArmsLine(armsLineProducts);
		return productInShopRepo.saveAll(productInShops);
	}

}
