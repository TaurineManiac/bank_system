package org.example.banksystemfromjavaacademy.service.impl;

import org.example.banksystemfromjavaacademy.dto.AccountInfo;
import org.example.banksystemfromjavaacademy.dto.AccountRequest;
import org.example.banksystemfromjavaacademy.dto.BankResponse;
import org.example.banksystemfromjavaacademy.entity.Account;
import org.example.banksystemfromjavaacademy.entity.User;
import org.example.banksystemfromjavaacademy.enums.AccountResponseConstants;
import org.example.banksystemfromjavaacademy.enums.UserResponseConstants;
import org.example.banksystemfromjavaacademy.exceptions.UserNotFoundException;
import org.example.banksystemfromjavaacademy.repository.AccountRepository;
import org.example.banksystemfromjavaacademy.repository.UserRepository;
import org.example.banksystemfromjavaacademy.utils.BankUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;
    UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository,  UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BankResponse createAccount(AccountRequest accountRequest) {

        User user = userRepository.findUserByPublicUserId(accountRequest.getUserPublicId())
                .orElseThrow(() -> new UserNotFoundException(UserResponseConstants.USER_NOT_FOUND));

        UUID uuid = BankUtils.generatePublicId();
        AtomicInteger atomicInteger = new AtomicInteger();
        while (accountRepository.existsByPublicAccountId(uuid)) {
            uuid = BankUtils.generatePublicId();
            atomicInteger.getAndIncrement();
            if(atomicInteger.get() >= 10){
                return BankResponse.builder()
                        .responseCode(AccountResponseConstants.ACCOUNT_ALREADY_EXISTS.getCode())
                        .responseMessage(AccountResponseConstants.ACCOUNT_ALREADY_EXISTS.getMessage())
                        .data(null)
                        .build();
            }
        }
        Account account = Account.builder()
                .publicAccountId(uuid)
                .accountBalance(BigDecimal.ZERO)
                .accountType(accountRequest.getAccountType())
                .accountStatus("ACTIVE")
                .creationDate(LocalDateTime.now())
                .modificationDate(LocalDateTime.now())
                .user(user)
                .build();

        Account savedAccount = accountRepository.save(account);

        return BankResponse.<AccountInfo>builder()
                .responseCode(AccountResponseConstants.ACCOUNT_CREATION_SUCCESS.getCode())
                .responseMessage(AccountResponseConstants.ACCOUNT_CREATION_SUCCESS.getMessage())
                .data(AccountInfo.builder()
                        .publicAccountId(savedAccount.getPublicAccountId())
                        .accountBalance(savedAccount.getAccountBalance())
                        .accountType(savedAccount.getAccountType())
                        .publicUserId(user.getPublicUserId())
                        .accountStatus(savedAccount.getAccountStatus())
                        .build())
                .build();
    }
}
