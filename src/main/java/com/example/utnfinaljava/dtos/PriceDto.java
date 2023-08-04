package com.example.utnfinaljava.dtos;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PriceDto {
    @NotNull(message = "El campo PersonaId no puede estar vacio")
    private Long personaId;
    @NotNull(message = "El campo productId no puede estar vacio")
    private Long productId;
    @NotNull(message = "El campo Fecha Vigencia no puede estar vacio")
    private Date dateFrom;
    @NotNull(message = "El campo Precio no puede estar vacio")
    @Max(value = 99999, message = "Se ha ingresado un valor máximo al permitido para el campo Precio")
    @Min(value = 99999, message = "El campo Precio de tener un valor mayor a 0")
    private Float price;
    
}
