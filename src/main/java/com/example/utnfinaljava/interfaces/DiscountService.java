package com.example.utnfinaljava.interfaces;

import java.util.Date;
import java.util.List;

import com.example.utnfinaljava.dtos.DiscountDto;

public interface DiscountService {
    List<DiscountDto> getTodayDiscount();

    List<DiscountDto> getDiscounts();

    DiscountDto create(DiscountDto discount);

    void delete(Date date, Float amount);
}
