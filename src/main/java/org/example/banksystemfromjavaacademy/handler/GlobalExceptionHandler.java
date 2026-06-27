package org.example.banksystemfromjavaacademy.handler;

import org.example.banksystemfromjavaacademy.dto.BankResponse;
import org.example.banksystemfromjavaacademy.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<BankResponse<?>> handleUserNotFoundException(UserNotFoundException ex) {
        BankResponse<?> response = BankResponse.builder()
                .responseCode(ex.getCode())
                .responseMessage(ex.getMessage())
                .data(null)
                .build();

        return ResponseEntity.status(ex.getHttpStatus()).body(response);
    }
}
