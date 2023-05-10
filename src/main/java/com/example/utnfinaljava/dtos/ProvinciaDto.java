package com.example.utnfinaljava.dtos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.example.utnfinaljava.util.validators.ProvinceUniqueId;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProvinciaDto {
    private Long code;
    @Size(max = 60, message = "La cantidad de caracteres ingresado superior al maximo permitido")
    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String nombre;
}
