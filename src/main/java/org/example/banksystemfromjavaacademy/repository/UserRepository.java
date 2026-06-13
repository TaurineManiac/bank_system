package org.example.banksystemfromjavaacademy.repository;

import org.example.banksystemfromjavaacademy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsByEmail(String email);
    Boolean existsByAccountNumber(String account);
    User findUserByEmail(String email);
    User findUserByAccountNumber(String account);
}
