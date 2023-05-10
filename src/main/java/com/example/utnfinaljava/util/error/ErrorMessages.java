package com.example.utnfinaljava.util.error;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

public class ErrorMessages {

    public static List<String> GetErrorMessages(BindingResult result){
        List<String> errores = result.getAllErrors().stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .collect(Collectors.toList());
        return errores;
    }
}
