package com.sweet_bites_delivery_service.exception.exceptionhandling;

import com.sweet_bites_delivery_service.exception.DeliveryNotFoundException;
import com.sweet_bites_delivery_service.exception.ValidationExceptionDeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class DeliveryServiceExceptionHandler {

    @ExceptionHandler({DeliveryNotFoundException.class})
    public ResponseEntity<String> handleDeliveryNotFoundException(DeliveryNotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ValidationExceptionDeliveryService.class)
    public ResponseEntity<String> handleValidationException(ValidationExceptionDeliveryService e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
    }
}
