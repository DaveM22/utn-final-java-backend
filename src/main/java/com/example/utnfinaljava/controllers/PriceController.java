package com.example.utnfinaljava.controllers;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseEntity<ResponseRequest<List<PriceDto>>> getAll(@PathVariable("idProducto") Long idProducto, @PathVariable("idPersona") Long idPersona){
        ResponseRequest<List<PriceDto>> response = new ResponseRequest<List<PriceDto>>();
        List<PriceDto> prices = priceService.getPriceById(idProducto, idPersona);
        response.setPayload(prices);
        return ResponseEntity.ok(response);
    };

    @PostMapping("/prices")
    public ResponseEntity<ResponseRequest<PriceDto>> post(@RequestBody PriceDto price){
        ResponseRequest<PriceDto> response = new ResponseRequest<PriceDto>();
        PriceDto dto = priceService.setPrice(price);
        response.setMessage("Se ha establecido un nuevo precio para el producto de manera existosa");
        response.setPayload(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/prices/{idPersona}/{idProducto}/{fecha}")
    public ResponseEntity<ResponseRequest<?>> delete(@PathVariable("idPersona") Long personaId, @PathVariable("idProducto") Long productId, @PathVariable("fecha") @DateTimeFormat(pattern= "yyyy-MM-dd") Date date){
        ResponseRequest<?> response = new ResponseRequest<Object>();
        priceService.deletePrice(personaId, productId, date);
        response.setMessage("Se ha eliminado el precio de manera existosa");
        return ResponseEntity.ok(response);
    }
}
