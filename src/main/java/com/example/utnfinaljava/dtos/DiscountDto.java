package com.example.utnfinaljava.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class DiscountDto {
    private Date validityDate;
    private float amountPrice;
    private float discount;
}
