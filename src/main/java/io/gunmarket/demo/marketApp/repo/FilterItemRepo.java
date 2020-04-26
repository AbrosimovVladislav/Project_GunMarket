package io.gunmarket.demo.marketApp.repo;

import io.gunmarket.demo.marketApp.model.FilterItem;
import io.gunmarket.demo.marketApp.repo.selectfrom.SelectFromRepo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FilterItemRepo extends JpaRepository<FilterItem, Long>, SelectFromRepo {
    List<FilterItem> findAllByMenuItem(String menuItem);
}
