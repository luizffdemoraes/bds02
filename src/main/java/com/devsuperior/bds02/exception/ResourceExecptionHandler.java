package com.devsuperior.bds02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExecptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Exception> entityNotFound(ResourceNotFoundException e){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(e);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<Exception> entityNotFound(DataBaseException e){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(e);
    }
}