package com.example.service.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class ValidControllerHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public List<ErrorMsg> exception(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<ErrorMsg> errorMsgs = new ArrayList<>();

        allErrors.forEach(
                objectError -> {
            ErrorMsg errorMsg = new ErrorMsg();
            FieldError fieldError = (FieldError)objectError;
            errorMsg.setField(fieldError.getField());
            errorMsg.setObjectName(fieldError.getObjectName());
            errorMsg.setMessage(fieldError.getDefaultMessage());
            log.error("error: {}",errorMsg);
            errorMsgs.add(errorMsg);
        });
        return errorMsgs;
    }

}
