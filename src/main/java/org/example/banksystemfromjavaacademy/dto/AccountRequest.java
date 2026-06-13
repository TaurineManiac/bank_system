package org.example.banksystemfromjavaacademy.dto;


import jakarta.validation.constraints.NotBlank;

public class AccountRequest {
    @NotBlank(message = "Account type is required!")
    private String accountType;
}
