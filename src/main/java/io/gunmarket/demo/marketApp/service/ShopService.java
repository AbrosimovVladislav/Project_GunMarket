package io.gunmarket.demo.marketApp.service;

import io.gunmarket.demo.marketApp.domain.Shop;
import io.gunmarket.demo.marketApp.repo.ShopRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ShopService {
	private final ShopRepo shopRepo;

	public Shop getById(long shopId) {
		return shopRepo.getOne(shopId);
	}

	public Shop update(Shop shop) {
		return shopRepo.saveAndFlush(shop);
	}
}
