package io.gunmarket.demo.marketApp.repo;

import io.gunmarket.demo.marketApp.model.domain.attributes.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepo extends JpaRepository<Type, Long> {}
