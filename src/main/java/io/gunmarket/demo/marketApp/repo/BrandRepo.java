package io.gunmarket.demo.marketApp.repo;

import io.gunmarket.demo.marketApp.model.domain.attributes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Long> {}
