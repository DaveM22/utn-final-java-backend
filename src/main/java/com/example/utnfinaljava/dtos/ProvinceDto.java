package com.example.utnfinaljava.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProvinceDto{
    private Long provinceCode;
    @Size(max = 60, message = "La cantidad de caracteres ingresado superior al maximo permitido")
    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String name;
}
