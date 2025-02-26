package com.github.bookCrud.exception;

import com.github.bookCrud.exception.customExc.EntityNotFoundExc;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExHandler{

    @ExceptionHandler(EntityNotFoundExc.class)
    public ResponseEntity<?> handleEntityNotFoundExc(EntityNotFoundExc entityExc){
       return new ResponseEntity<>(entityExc.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException nullExc){
        return new ResponseEntity<>(nullExc.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException nullableExc){
        return new ResponseEntity<>(nullableExc.getMessage(), HttpStatus.BAD_REQUEST);
    }

    }
