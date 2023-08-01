package com.example.utnfinaljava.dtos;

import lombok.Data;

@Data
public class OrderDetailDto {
    public Long orderNumber;
    public Long productId;
    public Long personaId;
    public Integer amount;
    public Float price;
    public Long total;
}
