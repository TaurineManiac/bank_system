package org.example.banksystemfromjavaacademy.repository;

import org.example.banksystemfromjavaacademy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
