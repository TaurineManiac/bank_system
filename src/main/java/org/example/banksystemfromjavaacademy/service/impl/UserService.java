package org.example.banksystemfromjavaacademy.service.impl;

import org.example.banksystemfromjavaacademy.dto.BankResponse;
import org.example.banksystemfromjavaacademy.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
