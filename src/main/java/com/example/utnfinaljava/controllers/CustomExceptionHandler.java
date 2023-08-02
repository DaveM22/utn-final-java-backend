package com.example.utnfinaljava.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.AmountIsZeroOrNullException;
import com.example.utnfinaljava.util.exceptions.LocationNotExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;
import com.example.utnfinaljava.util.exceptions.PriceIsZeroOrNullException;
import com.example.utnfinaljava.util.exceptions.StockIsNegativeException;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ResponseRequest> handleAlreadyException(AlreadyExistException ex) {
        ResponseRequest response = new ResponseRequest();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(NotExistException.class)
    public ResponseEntity<ResponseRequest> handleNoExistException(NotExistException ex) {
        ResponseRequest response = new ResponseRequest();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(AmountIsZeroOrNullException.class)
    public ResponseEntity<ResponseRequest> handleNoExistException(AmountIsZeroOrNullException ex) {
        ResponseRequest response = new ResponseRequest();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(StockIsNegativeException.class)
    public ResponseEntity<ResponseRequest> handleNoExistException(StockIsNegativeException ex) {
        ResponseRequest response = new ResponseRequest();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ResponseRequest> handleNoExistException(BadCredentialsException ex) {
        ResponseRequest response = new ResponseRequest();
        response.setErrorMessage("El usuario y/o contraseña son incorrectos");
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(LocationNotExistException.class)
    public ResponseEntity<ResponseRequest> handleNoExistException(LocationNotExistException ex) {
        ResponseRequest response = new ResponseRequest();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(PriceIsZeroOrNullException.class)
    public ResponseEntity<ResponseRequest> handlePriceIsZeroException(PriceIsZeroOrNullException ex) {
        ResponseRequest response = new ResponseRequest();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
