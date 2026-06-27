package org.example.banksystemfromjavaacademy.exceptions;

import lombok.Getter;
import org.example.banksystemfromjavaacademy.enums.ResponseCode;
import org.springframework.http.HttpStatus;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final String code;
    private final HttpStatus httpStatus;



    public UserNotFoundException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
        this.httpStatus = responseCode.getHttpStatus();
    }
}
