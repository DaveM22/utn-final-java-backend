package com.example.utnfinaljava.dtos;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderDto {
    private Long orderNumber;
    private Date orderDate;
    private String customer;
    private String customerCuit;
    private Long totalAmount;
    private List<OrderDetailDto> details;
}
