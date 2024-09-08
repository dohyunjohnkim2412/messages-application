package com.example.messages.message.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MessageNotFoundAdvice {
    @ExceptionHandler(MessageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> messageNotFoundHandler(MessageNotFoundException error) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", error.getMessage());
        return errorResponse;
    }
}
