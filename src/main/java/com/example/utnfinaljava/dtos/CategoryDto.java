package com.example.utnfinaljava.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDto {
    private Long categoryId;
    @NotBlank(message = "El campo Nombre no puede estar vacio")
    @Length(max = 40, message = "El campo Nombre solo admite hasta 40 caracteres")
    private String name;
}
