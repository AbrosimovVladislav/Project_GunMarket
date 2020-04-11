package io.gunmarket.demo.marketApp.web.controller;

import io.gunmarket.demo.marketApp.model.domain.account.Account;
import io.gunmarket.demo.marketApp.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/registration")
    public ResponseEntity<Account> addAccount(@Valid Account account, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build(); // перепилить в норм вид)
        }
        return ResponseEntity.ok(accountService.saveAccount(account));
    }
}
