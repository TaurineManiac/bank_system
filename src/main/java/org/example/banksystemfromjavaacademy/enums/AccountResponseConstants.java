package org.example.banksystemfromjavaacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountResponseConstans {
    ACCOUNT_ALREADY_EXISTS("001", "This account already exists"),
    ACCOUNT_CREATION_SUCCESS("002", "Account successfully created");


    private final String code;
    private final String message;
}
