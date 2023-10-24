package com.sharmal.validationexceptionhandling.advice;

import com.sharmal.validationexceptionhandling.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException e) {
        Map<String, String> errResponse = new HashMap<>();
//        errResponse.put("error", "Validation failed");
//        return errResponse;
        e.getBindingResult().getFieldErrors().forEach(error -> {
            errResponse.put(error.getField(), error.getDefaultMessage());
        });
        return errResponse;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleBusinessException(UserNotFoundException e) {
        Map<String, String> errResponse = new HashMap<>();
        errResponse.put("Error Message", e.getMessage());
        return errResponse;
    }
}
