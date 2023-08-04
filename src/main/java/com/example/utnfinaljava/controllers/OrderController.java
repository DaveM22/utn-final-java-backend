package com.example.utnfinaljava.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.utnfinaljava.dtos.OrderDto;
import com.example.utnfinaljava.dtos.OrderReportDto;
import com.example.utnfinaljava.dtos.OrderViewDto;
import com.example.utnfinaljava.interfaces.OrderService;
import com.example.utnfinaljava.responses.ResponseRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrderController {
    
    private final OrderService orderRepository;

    @GetMapping("/orders")
    public ResponseEntity<ResponseRequest<List<OrderViewDto>>> getAll(){
        ResponseRequest<List<OrderViewDto>> response = new ResponseRequest<List<OrderViewDto>>();
        List<OrderViewDto> dtos = orderRepository.getOrders();
        response.setPayload(dtos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/orders")
    public ResponseEntity<ResponseRequest<OrderDto>> post(@Valid @RequestBody OrderDto order, BindingResult result){
    
        ResponseRequest<OrderDto> response = new ResponseRequest<OrderDto>();
        orderRepository.createOrder(order);
        response.setMessage("Se ha registrado la compra de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<ResponseRequest<OrderReportDto>> getById(@PathVariable("id") Long orderId){
        ResponseRequest<OrderReportDto> response = new ResponseRequest<OrderReportDto>();
        OrderReportDto dto = orderRepository.getOrderById(orderId);
        response.setPayload(dto);
        response.setMessage("Se ha registrado la compra de manera exitosa");
        return ResponseEntity.ok(response);
    }
}
