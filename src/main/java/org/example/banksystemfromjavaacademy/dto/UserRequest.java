package org.example.banksystemfromjavaacademy.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class UserRequest {
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String address;
    private String stateOfOrigin;
    private String email;
    private String phoneNumber;
    private String alternativePhoneNumber;
    private String status;
}
