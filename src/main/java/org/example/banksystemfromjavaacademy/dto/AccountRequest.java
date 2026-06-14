package org.example.banksystemfromjavaacademy.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class AccountRequest {
    @NotBlank(message = "Account type is required!")
    private String accountType;
    @NotNull(message = "Account owner's id is required!")
    private UUID userPublicId;
}
