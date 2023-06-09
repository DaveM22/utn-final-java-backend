package com.example.utnfinaljava.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.utnfinaljava.dtos.AuthenticationRequestDto;
import com.example.utnfinaljava.dtos.AuthenticationResponseDto;
import com.example.utnfinaljava.dtos.RegisterRequest;
import com.example.utnfinaljava.entities.User;
import com.example.utnfinaljava.repositories.UserRepository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseDto Register(RegisterRequest request) {
        var user = new User();
        user.setEmail(request.getEmail());
        user.setClave(passwordEncoder.encode(request.getPassword()));
        user.setNombreUsuario(request.getName());
        usuarioRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("no encontrado"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder().token(jwtToken).build();
    }
}
