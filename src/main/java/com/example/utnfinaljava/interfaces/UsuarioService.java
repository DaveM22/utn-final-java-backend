package com.example.utnfinaljava.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.utnfinaljava.entities.Usuario;

public interface UsuarioService extends JpaRepository<Usuario , Long> {

    Optional<Usuario> findByEmail(String email);
}
