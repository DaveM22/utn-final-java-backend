package com.example.utnfinaljava.dtos;

import com.example.utnfinaljava.util.validators.ProvinceUniqueId;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProvinciaDto {
    @ProvinceUniqueId
    @NotNull(message = "El campo codígo no puede estar vacio")
    private Long codigo;
    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String nombre;
}
