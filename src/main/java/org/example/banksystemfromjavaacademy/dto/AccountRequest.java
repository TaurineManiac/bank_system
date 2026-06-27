package org.example.banksystemfromjavaacademy.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountRequest {
    @NotBlank(message = "Account type is required!")
    private String accountType;
    @NotNull(message = "Account owner's id is required!")
    private UUID userPublicId;
}
