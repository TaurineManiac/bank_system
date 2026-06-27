package org.example.banksystemfromjavaacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum UserResponseConstants implements ResponseCode {
    USER_ALREADY_EXISTS("003", "User already exists", HttpStatus.CONFLICT),
    USER_CREATION_SUCCESS("004", "User successfully created", HttpStatus.CREATED),
    USER_NOT_FOUND("006", "User not found", HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}
