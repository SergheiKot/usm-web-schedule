package com.sergheikot.usmwebschedule.controller;

import com.sergheikot.usmwebschedule.exception.NotAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNotAccessException(Exception exception) {

        if (exception instanceof NotAccessException) {
            return new ResponseEntity<>("You don't have access!", HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
