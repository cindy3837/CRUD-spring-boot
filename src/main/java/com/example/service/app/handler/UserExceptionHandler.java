package com.example.service.app.handler;

import com.example.service.app.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerInterceptor;

@ControllerAdvice
public class UserExceptionHandler implements HandlerInterceptor {

    @ExceptionHandler(UserException.class)
    public Object exceptionHandler(UserException e) {
        String message = e.getMessage();
        String msg = "get error: UserException: " + message;

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
    }




}
