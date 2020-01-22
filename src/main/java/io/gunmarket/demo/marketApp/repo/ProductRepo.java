package io.gunmarket.demo.marketApp.repo;

import io.gunmarket.demo.marketApp.model.domain.Product;
import io.gunmarket.demo.marketApp.repo.filterandsorting.FilterAndSortingRepository;
import io.gunmarket.demo.marketApp.repo.searchProductRepo.SearchProductRepo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product, Long>, FilterAndSortingRepository<Product>, SearchProductRepo {}
