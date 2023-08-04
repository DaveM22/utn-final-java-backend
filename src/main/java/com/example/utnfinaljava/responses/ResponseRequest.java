package com.example.utnfinaljava.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ResponseRequest<T> {

    public ResponseRequest(){
        
    }

    private String errorMessage;
    private String message;
    private T Payload;    
}
