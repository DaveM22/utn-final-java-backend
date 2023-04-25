package com.example.utnfinaljava.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.dtos.OrderDto;
import com.example.utnfinaljava.interfaces.OrderService;
import com.example.utnfinaljava.repositories.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<OrderDto> getOrders() {
        var entities = orderRepository.findAll();
        List<OrderDto> dtos = entities.stream().map(a -> modelMapper.map(a, OrderDto.class))
        .collect(Collectors.toList());
        return dtos;
    }
    
}
