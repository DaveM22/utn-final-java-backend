package com.example.utnfinaljava.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SupplierDto extends PersonaDto {
    @NotBlank(message = "El campo Razón social no puede estar vacio")
    @Length(max = 40,message = "El campo Razón social solo admite hasta 40 caracteres")
    private String businessName;
    @NotBlank(message = "El campo Cuit no puede estar vacio")
    @Length(max = 20,message = "El campo Razon social solo admite hasta 20 caracteres")
    private String cuit;
}
