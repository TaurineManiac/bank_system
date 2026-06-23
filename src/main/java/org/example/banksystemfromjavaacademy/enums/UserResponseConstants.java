package org.example.banksystemfromjavaacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserResponseConstants {
    USER_ALREADY_EXISTS("003", "This User already exists!"),
    USER_CREATION_SUCCESS("004", "User successfully created!");

    private final String responseCode;
    private final String responseMessage;
}
