package io.gunmarket.demo.dbUpdater.mapper;

import io.gunmarket.demo.dbUpdater.repo.ShopRepo;
import io.gunmarket.demo.dbUpdater.shop.armsline.ArmsLineProduct;
import io.gunmarket.demo.product.domain.ProductInShop;
import io.gunmarket.demo.product.domain.Shop;
import io.gunmarket.demo.product.domain.product.Product;
import io.gunmarket.demo.product.repo.ProductRepo;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductInShopMapper {

	private final ProductRepo productRepo;

	private final ShopRepo shopRepo;

	public ProductInShopMapper(ProductRepo productRepo, ShopRepo shopRepo) {
		this.productRepo = productRepo;
		this.shopRepo = shopRepo;
	}

	public List<ProductInShop> fromArmsLine(Collection<ArmsLineProduct> armsLineProducts) {
		return armsLineProducts.stream()
				.map(e -> {
					Product product = getProductByMatch(e);
					Shop shop = getShopById(e);
					double price = e.getPrice();
					double salePrice = e.getSalePrice();
					boolean inStock = e.isInStock();
					String link = e.getLink();
					int sale = (int) ((1.0 - salePrice / price) * 100.0);
					return new ProductInShop(product, shop, price, inStock, link, sale);
				})
				.collect(Collectors.toList());
	}

	private Product getProductByMatch(ArmsLineProduct armsLineProduct) {
		return productRepo.getOne(1L);
	}

	private Shop getShopById(ArmsLineProduct armsLineProduct) {
		return shopRepo.getOne(1L);
	}
}
