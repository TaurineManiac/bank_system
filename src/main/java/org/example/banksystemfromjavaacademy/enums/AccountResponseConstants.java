package org.example.banksystemfromjavaacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum AccountResponseConstants implements ResponseCode {
    ACCOUNT_ALREADY_EXISTS("001", "This account already exists", HttpStatus.CONFLICT),
    ACCOUNT_CREATION_SUCCESS("002", "Account successfully created",  HttpStatus.CREATED),
    ACCOUNT_NOT_FOUND("005", "Account not found",  HttpStatus.NOT_FOUND);


    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}
