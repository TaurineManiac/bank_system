package org.example.banksystemfromjavaacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountInfo {
    private UUID publicAccountId;
    private BigDecimal accountBalance;
    private String accountType;
    private UUID publicUserId;
    private String accountStatus;
}
