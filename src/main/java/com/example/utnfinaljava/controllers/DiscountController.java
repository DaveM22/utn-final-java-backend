package com.example.utnfinaljava.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.DiscountDto;
import com.example.utnfinaljava.interfaces.DiscountService;
import com.example.utnfinaljava.responses.ResponseRequest;

import jakarta.validation.Valid;
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

    @GetMapping("/discount/all")
    public ResponseEntity<ResponseRequest> getAll(){
        ResponseRequest response = new ResponseRequest();
        List<DiscountDto> dtos = discountService.getTodayDiscount();
        response.setPayload(dtos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/discount")
    public ResponseEntity<ResponseRequest> post(@Valid @RequestBody DiscountDto discountDto,  BindingResult result){
        ResponseRequest response = new ResponseRequest();
        DiscountDto dto = discountService.create(discountDto);
        response.setPayload(dto);
        response.setMessage("Se ha agregado el descuento de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/discount/{fecha}/{amount}")
    public ResponseEntity<ResponseRequest> delete(@PathVariable("amount") Float amount, @DateTimeFormat(pattern= "yyyy-MM-dd") Date fecha){
        ResponseRequest response = new ResponseRequest();
        discountService.delete(fecha, amount);
        response.setMessage("Se ha borrado el descuento de manera existosa");
        return ResponseEntity.ok(response);
    }
}
