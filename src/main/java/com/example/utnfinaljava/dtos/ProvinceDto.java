package com.example.utnfinaljava.dtos;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProvinceDto {
    private long provinceCode;
    @NotBlank(message = "El campo nombre no puede estar vacio")
    @Length(max = 35, message = "El campo Nombre de provincia solo admite hasta 40 caracteres")
    private String name;
}
