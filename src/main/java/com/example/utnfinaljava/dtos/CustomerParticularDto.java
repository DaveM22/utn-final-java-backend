package com.example.utnfinaljava.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerParticularDto extends PersonaDto {
    @NotBlank(message = "El campo Nombre no puede estar vacio")
    @Length(max = 40,message = "El campo Nombre solo admite hasta 40 caracteres")
    private String firstName;

    @NotBlank(message = "El campo Apellido no puede estar vacio")
    @Length(max = 40,message = "El campo Apellido solo admite hasta 40 caracteres")
    private String lastName;
    @NotBlank(message = "El campo Dni no puede estar vacio")
    @Length(max=15, message = "El campo Dni solo admite hasta 15 caracteres")
    private String dni;
}
