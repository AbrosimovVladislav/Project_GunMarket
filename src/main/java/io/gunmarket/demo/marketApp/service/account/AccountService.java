package io.gunmarket.demo.marketApp.service.account;

import io.gunmarket.demo.marketApp.model.domain.account.Account;
import io.gunmarket.demo.marketApp.repo.account.AccountRepo;
import io.gunmarket.demo.marketApp.web.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepo accountRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        return accountRepo.findByAccountName(accountName).orElseThrow(() -> new UsernameNotFoundException("Account not found"));
    }

    public Account saveAccount(Account account) {
        accountRepo.findByAccountName(account.getUsername()).ifPresent(e -> {
            throw new UserAlreadyExistsException("Account already exists");
        });

        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        return accountRepo.save(account);
    }

}
