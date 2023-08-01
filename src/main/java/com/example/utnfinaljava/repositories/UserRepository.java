package com.example.utnfinaljava.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.utnfinaljava.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
 