package io.gunmarket.demo.marketApp.repo.account;

import io.gunmarket.demo.marketApp.model.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountName(String accountName);
}
