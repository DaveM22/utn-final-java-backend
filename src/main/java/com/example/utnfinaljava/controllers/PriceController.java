package com.example.utnfinaljava.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.PriceDto;
import com.example.utnfinaljava.interfaces.PriceService;
import com.example.utnfinaljava.responses.ResponseRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class PriceController {
    
    private final PriceService priceService;

    @GetMapping("/prices/{idProducto}/{idPersona}")
    public ResponseEntity<ResponseRequest> getPrices(@PathVariable("idProducto") Long idProducto, @PathVariable("idPersona") Long idPersona){
        ResponseRequest response = new ResponseRequest();
        List<PriceDto> prices = priceService.getPriceById(idProducto, idPersona);
        response.setPayload(prices);
        return ResponseEntity.ok(response);
    };

    @PostMapping("/prices")
    public ResponseEntity<ResponseRequest> postPrice(@RequestBody PriceDto price){
        ResponseRequest response = new ResponseRequest();
        PriceDto dto = priceService.SetPrice(price);
        response.setMessage("Se ha establecido un nuevo precio para el producto de manera existosa");
        response.setPayload(dto);
        return ResponseEntity.ok(response);
    }
}
