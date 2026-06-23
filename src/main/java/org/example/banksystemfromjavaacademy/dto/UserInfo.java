package org.example.banksystemfromjavaacademy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserInfo implements BankInfo{
    @NotEmpty
    private UUID publicUserId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String otherName;
    @NotBlank
    private String gender;
    @NotBlank
    private String address;
    @NotBlank
    private String stateOfOrigin;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String alternativePhoneNumber;
    @NotBlank
    private String status;
}
