package org.example.banksystemfromjavaacademy.controller;


import org.example.banksystemfromjavaacademy.dto.AccountRequest;
import org.example.banksystemfromjavaacademy.dto.BankResponse;
import org.example.banksystemfromjavaacademy.service.impl.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("create_account")
    public ResponseEntity<BankResponse> getAccount(@RequestBody AccountRequest accountRequest) {
        BankResponse response= accountService.createAccount(accountRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
