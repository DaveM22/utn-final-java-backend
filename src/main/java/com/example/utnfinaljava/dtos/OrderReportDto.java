package com.example.utnfinaljava.dtos;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderReportDto {
    private Date dateFrom;
    private String customerName;
    private String direction;
    private String email;
    private Float discount;
    private List<OrderDetailReportDto> Details;
}
