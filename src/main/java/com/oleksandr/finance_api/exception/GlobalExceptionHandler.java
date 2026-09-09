package com.oleksandr.finance_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

// Global Handler for contoller exceptions
@RestControllerAdvice
public class GlobalExceptionHandler
{
        // Catch "IllegalArgumentException" type
        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<Map<String,String>> handleIllegalArgumment(
                IllegalArgumentException exception
        ) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("message", exception.getMessage()));
        }
}

