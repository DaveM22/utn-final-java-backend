package com.example.utnfinaljava.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class PriceDto {
    private Long personaId;
    private Long productId;
    private Date dateFrom;
    private Long price;
}
