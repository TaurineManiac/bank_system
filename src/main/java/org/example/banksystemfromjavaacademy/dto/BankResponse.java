package org.example.banksystemfromjavaacademy.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankResponse<T extends BankInfo> {
    private String responseCode;
    private String responseMessage;
    private T data;
}
