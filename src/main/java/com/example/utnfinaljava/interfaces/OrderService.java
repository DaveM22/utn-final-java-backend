package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.OrderDto;
import com.example.utnfinaljava.dtos.OrderViewDto;

public interface OrderService {
    
    List<OrderViewDto> getOrders();

    void createOrder(OrderDto order);

}
