package com.example.utnfinaljava.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonaDto {
    private Long id;
    @NotBlank(message = "El campo Dirección no puede estar vacio")
    private String direction;
    private String phoneNumber;
    private String email;
    @NotNull(message = "El campo Dirección no puede estar vacio")
    private Long postalCode;
}
