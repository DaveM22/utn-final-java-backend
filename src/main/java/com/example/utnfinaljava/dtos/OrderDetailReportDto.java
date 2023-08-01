package com.example.utnfinaljava.dtos;

import lombok.Data;

@Data
public class OrderDetailReportDto {
    public String productName;
    public String supplierName;
    public Integer amount;
    public Long total;
    public Float price;
}
