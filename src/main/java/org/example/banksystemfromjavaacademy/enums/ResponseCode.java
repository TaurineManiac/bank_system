package org.example.banksystemfromjavaacademy.exceptions;

import org.springframework.http.HttpStatus;

public interface ResponseCode {
    String getCode();
    String getMessage();
    HttpStatus getHttpStatus();
}
