package com.example.utnfinaljava.dtos;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderDto {
    private Long orderNumber;
    private Date Date;
    private Long personaId;
    private List<OrderDetailDto> details;
}
