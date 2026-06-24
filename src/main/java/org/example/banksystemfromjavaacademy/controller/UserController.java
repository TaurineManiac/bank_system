package org.example.banksystemfromjavaacademy.controller;

import org.example.banksystemfromjavaacademy.dto.AccountRequest;
import org.example.banksystemfromjavaacademy.dto.BankResponse;
import org.example.banksystemfromjavaacademy.entity.Account;
import org.example.banksystemfromjavaacademy.service.impl.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccuntService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create_account")
    public Account createAccount(@RequestBody AccountRequest account){
        BankResponse bankResponse = new BankResponse();
        return
    }

}
