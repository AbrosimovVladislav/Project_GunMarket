package io.gunmarket.demo.marketApp.web.mapper;

import io.gunmarket.demo.marketApp.domain.Product;
import io.gunmarket.demo.marketApp.domain.Review;
import io.gunmarket.demo.marketApp.domain.Shop;
import io.gunmarket.demo.marketApp.service.ProductService;
import io.gunmarket.demo.marketApp.service.ShopService;
import io.gunmarket.demo.marketApp.web.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ReviewMapper {
	private final ShopService shopService;
	private final ProductService productService;

	public Review map(ReviewDto reviewDto) {
		Shop shop = reviewDto.getShopId() == null ? null : shopService.getById(reviewDto.getShopId());
		Product product = reviewDto.getProductId() == null ? null : productService.getById(reviewDto.getProductId());
		return new Review()
			.setMark(reviewDto.getMark())
			.setPros(reviewDto.getPros())
			.setCons(reviewDto.getCons())
			.setComment(reviewDto.getComment())
			.setShop(shop)
			.setProduct(product)
			.setUser(reviewDto.getUserId());
	}
}
