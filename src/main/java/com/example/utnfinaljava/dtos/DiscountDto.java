package com.example.utnfinaljava.dtos;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DiscountDto {
    @NotNull(message = "El campo Fecha vigencia no puede estar vacío")
    private Date validityDate;
    @NotNull(message = "El campo Monto no puede estar vacío")
    private Float amountPrice;
    @NotNull(message = "El campo Porcentaje no puede estar vacío")
    @Max(value=50, message="La cantidad maxima de porcentaje de descuento es 50")
    private Float discount;
}
