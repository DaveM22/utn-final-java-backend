package com.example.utnfinaljava.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerParticularDto extends PersonaDto {
    private String firstName;
    private String lastName;
    private String dni;
}
