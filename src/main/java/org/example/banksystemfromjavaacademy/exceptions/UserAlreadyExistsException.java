package org.example.banksystemfromjavaacademy.exceptions;

import lombok.Getter;
import org.example.banksystemfromjavaacademy.enums.ResponseCode;
import org.springframework.http.HttpStatus;

@Getter
public class UserAlreadyExistsException extends RuntimeException {

    private final String code;
    private final HttpStatus httpStatus;

    public UserAlreadyExistsException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
        this.httpStatus = responseCode.getHttpStatus();
    }
}
