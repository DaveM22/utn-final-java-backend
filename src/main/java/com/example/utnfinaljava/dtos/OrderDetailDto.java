package com.example.utnfinaljava.dtos;

import lombok.Data;

@Data
public class OrderDetailDto {
    public int orderNumber;
    public int productId;
    public String cuit;
    public int amount;
}
