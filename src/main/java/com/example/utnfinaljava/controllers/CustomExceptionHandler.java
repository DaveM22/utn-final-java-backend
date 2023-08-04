package com.example.utnfinaljava.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.AmountIsZeroOrNullException;
import com.example.utnfinaljava.util.exceptions.LocationNotExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;
import com.example.utnfinaljava.util.exceptions.PersistenceException;
import com.example.utnfinaljava.util.exceptions.PriceIsZeroOrNullException;
import com.example.utnfinaljava.util.exceptions.StockIsNegativeException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }


   
    
    
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ResponseRequest<?>> handleAlreadyException(AlreadyExistException ex) {
        ResponseRequest<?> response = new ResponseRequest<Object>();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(NotExistException.class)
    public ResponseEntity<ResponseRequest<?>> handleNoExistException(NotExistException ex) {
         ResponseRequest<?> response = new ResponseRequest<Object>();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(AmountIsZeroOrNullException.class)
    public ResponseEntity<ResponseRequest<?>> handleNoExistException(AmountIsZeroOrNullException ex) {
         ResponseRequest<?> response = new ResponseRequest<Object>();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(StockIsNegativeException.class)
    public ResponseEntity<ResponseRequest<?>> handleNoExistException(StockIsNegativeException ex) {
        ResponseRequest<?> response = new ResponseRequest<Object>();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ResponseRequest<?>> handleNoExistException(BadCredentialsException ex) {
        ResponseRequest<?> response = new ResponseRequest<Object>();
        response.setErrorMessage("El usuario y/o contraseña son incorrectos");
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(LocationNotExistException.class)
    public ResponseEntity<ResponseRequest<?>> handleNoExistException(LocationNotExistException ex) {
         ResponseRequest<?> response = new ResponseRequest<Object>();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(PriceIsZeroOrNullException.class)
    public ResponseEntity<ResponseRequest> handlePriceIsZeroException(PriceIsZeroOrNullException ex) {
        ResponseRequest response = new ResponseRequest();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<ResponseRequest> handlePersistenceException(PersistenceException ex) {
        ResponseRequest response = new ResponseRequest();
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
