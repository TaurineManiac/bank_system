package org.example.banksystemfromjavaacademy.repository;

import org.example.banksystemfromjavaacademy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByPublicUserId(UUID userId);
}
