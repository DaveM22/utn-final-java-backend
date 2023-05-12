package com.example.utnfinaljava.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.utnfinaljava.dtos.AuthenticationRequestDto;
import com.example.utnfinaljava.dtos.AuthenticationResponseDto;
import com.example.utnfinaljava.dtos.RegisterRequest;
import com.example.utnfinaljava.services.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthenticationService service;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody RegisterRequest request ){
        return ResponseEntity.ok(service.Register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> aunthenticateRequest(@RequestBody AuthenticationRequestDto request ){

            return ResponseEntity.ok(service.authenticate(request));

        
    }
}
