package com.example.utnfinaljava.dtos;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LocationDto {
    
    @NotNull(message = "El campo Provincia no puede estar vacío ")
    @Max(value = 9999, message = "El valor del campo Código postal ha excedido su valor límite máximo")
    private Long postalCode;

    @NotBlank(message = "El campo Ciudad no puede estar vacio")
    @Length(max = 30, message = "El campo Ciudad solo admite hasta 30 caracteres")
    private String city;

    @NotNull(message = "El campo Provincia no puede estar vacío")
    private Long provinceCode;
    private String name;
}
