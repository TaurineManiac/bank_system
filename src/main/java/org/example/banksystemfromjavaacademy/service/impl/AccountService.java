package org.example.banksystemfromjavaacademy.service.impl;

import org.example.banksystemfromjavaacademy.dto.AccountRequest;
import org.example.banksystemfromjavaacademy.dto.BankResponse;

public interface AccountService {
    BankResponse createAccount(AccountRequest accountRequest);
}
