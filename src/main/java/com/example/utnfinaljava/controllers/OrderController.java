package com.example.utnfinaljava.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.utnfinaljava.dtos.OrderDto;
import com.example.utnfinaljava.interfaces.OrderService;
import com.example.utnfinaljava.responses.ResponseRequest;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrderController {
    
    private final OrderService orderRepository;

    @GetMapping("/orders")
    public ResponseEntity<ResponseRequest> getOrders(){
        ResponseRequest response = new ResponseRequest();
        List<OrderDto> dtos = orderRepository.getOrders();
        response.setPayload(dtos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/orders")
    public ResponseEntity<ResponseRequest> postOrder(@RequestBody OrderDto order){
        ResponseRequest response = new ResponseRequest();
        orderRepository.createOrder(order);
        response.setMessage("Se ha registrado la compra correctamente");
        return ResponseEntity.ok(response);
    }
}
