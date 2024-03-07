package com.sweet_bites_delivery_service.validator;

import com.sweet_bites_delivery_service.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeliveryValidator {

    public void validateDelivery() throws ValidationException {
        List<String> violations = new ArrayList<>();

        // Добавьте сюда проверки ваших полей доставки и заполните список нарушений

        if (!violations.isEmpty()) {
            throw new ValidationException("Delivery validation failed", (Throwable) violations);
        }
    }
}
