package com.example.utnfinaljava.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class PriceDto {
    private Date dateFrom;
    private Long price;
}
