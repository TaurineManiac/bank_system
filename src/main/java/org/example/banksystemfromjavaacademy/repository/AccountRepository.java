package org.example.banksystemfromjavaacademy.repository;

import org.example.banksystemfromjavaacademy.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findByUser_PublicUserId(UUID publicUserId);
    Optional<Account> findByPublicAccountId(UUID publicAccountId);
    Boolean existsByPublicAccountId(UUID publicAccountId);
}
