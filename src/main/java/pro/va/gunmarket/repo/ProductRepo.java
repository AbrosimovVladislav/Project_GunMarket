package pro.va.gunmarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.va.gunmarket.domain.product.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {}
