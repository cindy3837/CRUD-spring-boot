package com.example.service.app.exception;

import lombok.Data;

@Data
public class UserException extends RuntimeException {

    private String message;

    public UserException(String message){
        this.message = message;
    }
}
