package com.example.utnfinaljava.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ResponseRequest {

    public ResponseRequest(){
        
    }

    private String errorMessage;
    private String message;
    private Object Payload;    
}
