package com.example.utnfinaljava.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestDto {
    @NotBlank(message = "El campo mail no puede estar vacio")
    private String email;
    @NotBlank(message = "El campo clave no puede estar vacio")
    private String password;
}
