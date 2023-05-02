package com.example.utnfinaljava.dtos;

import lombok.Builder;
import lombok.Data;

@Data
public class PersonaDto {
    private Long id;
    private String direction;
    private String phoneNumber;
    private String email;
    private Long postalCod;
}
