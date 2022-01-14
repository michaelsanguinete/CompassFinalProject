package com.compass.finalproject.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse extends RuntimeException{
    
    public ExceptionResponse(String message) {
        this.message = message;
    }
    private int status;
    private String message;

}
