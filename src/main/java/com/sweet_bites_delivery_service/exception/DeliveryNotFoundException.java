package com.sweet_bites_delivery_service.exception;

public class DeliveryNotFoundException extends RuntimeException {

    public DeliveryNotFoundException() {
        super();
    }

    public DeliveryNotFoundException(String message) {
        super(message);
    }

    public DeliveryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeliveryNotFoundException(Throwable cause) {
        super(cause);
    }
}
