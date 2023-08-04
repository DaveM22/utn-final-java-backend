package com.example.utnfinaljava.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    @NotBlank(message = "El campo Descripción no puede estar vacío")
    private String description;
    @NotNull(message = "El campo Categoría no puede estar vacío")
    private Long categoryId;
    private String categoryName;
    private Long amount;
}
