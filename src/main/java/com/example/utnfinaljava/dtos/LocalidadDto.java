package com.example.utnfinaljava.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LocalidadDto {

    private Long codigo;

    @NotNull(message = "El campo ciudad es obligatorio")
    private String ciudad;

    @NotNull(message = "El campo provincia es obligatorio")
    private ProvinciaDto provincia;
}
