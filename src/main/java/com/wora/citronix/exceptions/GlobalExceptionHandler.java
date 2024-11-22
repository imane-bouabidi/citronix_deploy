package com.wora.citronix.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SuperficieDepasseeException.class)
    public ResponseEntity<Object> handleSuperficieDepasseeException(SuperficieDepasseeException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SuperficieMinimumException.class)
    public ResponseEntity<Object> handleSuperficieMinimumException(SuperficieMinimumException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Superficie50Exception.class)
    public ResponseEntity<Object> handleSuperficie50Exception(Superficie50Exception ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}

