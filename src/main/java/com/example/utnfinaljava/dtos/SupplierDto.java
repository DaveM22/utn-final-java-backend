package com.example.utnfinaljava.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SupplierDto extends PersonaDto {
    private String businessName;
    private String cuit;
}
