package com.example.utnfinaljava.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LocationDto {
    
    @NotNull(message = "El campo provincia es un obligatorio")
    @Positive(message = "El valor del código postal ingresada es inválido o inexistente")
    private Long postalCode;

    @NotBlank(message = "El campo ciudad es obligatorio")
    private String city;

    @NotNull(message = "El campo provincia es un obligatorio")
    @Positive(message = "El valor de la provincia ingresada es inválido o inexistente")
    private Long provinceCode;

    private String provinceName;
}
