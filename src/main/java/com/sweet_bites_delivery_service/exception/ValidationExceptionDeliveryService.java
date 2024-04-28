package com.sweet_bites_delivery_service.exception;

public class ValidationExceptionDeliveryService extends RuntimeException {

    public ValidationExceptionDeliveryService(String message) {
        super(message);
    }

    public ValidationExceptionDeliveryService(String message, Throwable cause) {
        super(message, cause);
    }
}
