package pro.va.gunmarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.va.gunmarket.domain.Shop;

public interface ShopRepo extends JpaRepository<Shop, Long> {}
