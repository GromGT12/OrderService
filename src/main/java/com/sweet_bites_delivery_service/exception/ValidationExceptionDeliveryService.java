package com.sweet_bites_delivery_service.exception;

import java.util.List;

public class ValidationExceptionDeliveryService extends RuntimeException {

    public ValidationExceptionDeliveryService(String message, List<String> violations) {
        super(message);
    }

    public ValidationExceptionDeliveryService(String message, Throwable cause) {
        super(message, cause);
    }
}
