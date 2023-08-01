package com.example.utnfinaljava.dtos;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderDto {
    @Max(value=0,message = "El valor del número de la cabecera de pedido debe ser 0")
    @Min(value=0,message = "El valor del número de la cabecera de pedido debe ser 0")
    private Long orderNumber;
    @NotNull(message = "El campo fecha es requerido")
    private Date Date;
    @Positive(message = "El campo persona es obligatorio")
    private Long personaId;
    @NotEmpty(message = "No se han ingresado lineas de detalles a la orden")
    private List<OrderDetailDto> details;
}
