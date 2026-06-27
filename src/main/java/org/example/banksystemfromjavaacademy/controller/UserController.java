package org.example.banksystemfromjavaacademy.controller;

import org.example.banksystemfromjavaacademy.dto.BankResponse;
import org.example.banksystemfromjavaacademy.dto.UserRequest;
import org.example.banksystemfromjavaacademy.service.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create_user")
    public ResponseEntity<BankResponse> createAccount(@RequestBody UserRequest userRequest){
        BankResponse response= userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
