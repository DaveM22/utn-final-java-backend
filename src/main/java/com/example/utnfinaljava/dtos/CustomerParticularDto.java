package com.example.utnfinaljava.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerParticularDto extends PersonaDto {
    private String firstName;
    private String lastName;
    private String dni;
}
