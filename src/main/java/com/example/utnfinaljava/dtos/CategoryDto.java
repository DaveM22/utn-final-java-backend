package com.example.utnfinaljava.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryDto {
    @NotNull(message = "El campo Id es obligatorio")
    private Long categoryId;
    @NotNull(message = "El campo Nombre es obligatorio")
    private String name;
}
