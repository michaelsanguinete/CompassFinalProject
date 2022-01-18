package com.compass.finalproject.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ExceptionResponse extends RuntimeException{

    private int status;
    private String message;


    public ExceptionResponse(int status) {
        this.status = status;
    }



}
