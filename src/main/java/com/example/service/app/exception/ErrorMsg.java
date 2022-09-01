package com.example.service.app.exception;

import lombok.Data;

@Data
public class ErrorMsg {

    private String field;
    private String objectName;
    private String message;


}
