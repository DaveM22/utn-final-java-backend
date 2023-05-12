package com.example.utnfinaljava.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.AmountIsZeroOrNullException;
import com.example.utnfinaljava.util.exceptions.NotExistException;

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
}
