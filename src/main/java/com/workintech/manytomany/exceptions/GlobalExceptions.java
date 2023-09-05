package com.workintech.manytomany.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> handleException(MovieException exception){
        GlobalErrorResponse response = new GlobalErrorResponse(exception.getHttpStatus().value(),
                exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, exception.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> handleException(Exception exception){
        log.error(exception.getMessage());
        GlobalErrorResponse response = new GlobalErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
