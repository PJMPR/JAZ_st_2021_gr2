package com.example.jazlab06.expection;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CreditNotFoundException.class)
    public ResponseEntity<Error> handleNotFound() {
        return ResponseEntity.notFound().build();
        //return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CreditAlreadyExistsException.class)
    public ResponseEntity<Error> handleBadRequest() {
        return ResponseEntity.badRequest().build();
        //return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
