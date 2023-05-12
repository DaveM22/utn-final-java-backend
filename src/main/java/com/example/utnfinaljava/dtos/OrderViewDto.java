package com.example.utnfinaljava.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class OrderViewDto {
    private Date dateFrom;
    private String customerName;
    private Long amountProducts;
}
