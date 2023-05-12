package com.example.utnfinaljava.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.DiscountDto;
import com.example.utnfinaljava.dtos.PriceDto;
import com.example.utnfinaljava.interfaces.DiscountService;
import com.example.utnfinaljava.responses.ResponseRequest;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class DiscountController {
    
    private final DiscountService discountService;


    @GetMapping("/discount")
    public ResponseEntity<ResponseRequest> getDiscounts(){
        ResponseRequest response = new ResponseRequest();
        List<DiscountDto> dto = discountService.getTodayDiscount();
        response.setPayload(dto);
        return ResponseEntity.ok(response);
    }
}
