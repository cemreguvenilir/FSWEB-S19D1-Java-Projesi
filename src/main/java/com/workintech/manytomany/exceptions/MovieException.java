package com.workintech.manytomany.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class MovieException extends RuntimeException{
    private HttpStatus httpStatus;

    public MovieException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
