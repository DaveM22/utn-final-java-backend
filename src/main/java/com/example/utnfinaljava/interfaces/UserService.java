package com.example.utnfinaljava.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.utnfinaljava.entities.User;

public interface UserService extends JpaRepository<User , Long> {

    Optional<User> findByEmail(String email);
}
