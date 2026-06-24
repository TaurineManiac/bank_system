package org.example.banksystemfromjavaacademy.service.impl;

import org.example.banksystemfromjavaacademy.dto.AccountInfo;
import org.example.banksystemfromjavaacademy.dto.BankResponse;
import org.example.banksystemfromjavaacademy.dto.UserInfo;
import org.example.banksystemfromjavaacademy.dto.UserRequest;
import org.example.banksystemfromjavaacademy.entity.User;
import org.example.banksystemfromjavaacademy.enums.AccountResponseConstants;
import org.example.banksystemfromjavaacademy.enums.UserResponseConstants;
import org.example.banksystemfromjavaacademy.repository.UserRepository;
import org.example.banksystemfromjavaacademy.utils.BankUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public BankResponse createUser(UserRequest userRequest) {
        /**
         * Creating User - saving a new user into DB
         * Next step is check if User already exist.
         */

        if(userRepository.existsByEmail(userRequest.getEmail())) {
            return BankResponse.builder()
                    .responseCode(UserResponseConstants.USER_ALREADY_EXISTS.getResponseCode())
                    .responseMessage(UserResponseConstants.USER_ALREADY_EXISTS.getResponseMessage())
                    .data(null)
                    .build();
        }



        User newUser = User.builder()
                .publicUserId(BankUtils.generatePublicId())   // UUIDv7
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .status("ACTIVE")
                .build();

        User savedUser = userRepository.save(newUser);

        return BankResponse.builder()
                .responseCode(UserResponseConstants.USER_CREATION_SUCCESS.getResponseCode())
                .responseMessage(UserResponseConstants.USER_CREATION_SUCCESS.getResponseMessage())
                .data(UserInfo.builder()
                        .publicUserId(savedUser.getPublicUserId())               // UUID
                        .firstName(savedUser.getFirstName())                     // String
                        .lastName(savedUser.getLastName())                       // String
                        .otherName(savedUser.getOtherName())                     // String
                        .gender(savedUser.getGender())                           // String
                        .address(savedUser.getAddress())                         // String
                        .stateOfOrigin(savedUser.getStateOfOrigin())             // String
                        .email(savedUser.getEmail())                             // String
                        .phoneNumber(savedUser.getPhoneNumber())                 // String
                        .alternativePhoneNumber(savedUser.getAlternativePhoneNumber()) // String
                        .status(savedUser.getStatus())                           // String
                        .build())
                .build();
    }
}
