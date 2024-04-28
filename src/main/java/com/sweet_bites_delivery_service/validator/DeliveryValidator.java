package com.sweet_bites_delivery_service.validator;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.exception.ValidationExceptionDeliveryService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryValidator {
    public void validatorDelivery(DeliveryDTO deliveryDTO) {
        List<String> violations = new ArrayList<>();
        validateId(deliveryDTO.getId(), violations);
        validateOrderId(deliveryDTO.getOrderId(), violations);

        // Перегрузка для обработки Integer
        validatePositive(deliveryDTO.getQuantity(), "Quantity", violations);

        // Для BigDecimal
        validatePositive(deliveryDTO.getTotalPrice(), "Total price", violations);

        validateFutureDate(deliveryDTO.getDeliveryDate(), violations);
        validateString(deliveryDTO.getDeliveryAddress(), "Delivery Address", violations);
        validateString(deliveryDTO.getDeliveryMethod(), "Delivery Method", violations);

        if (!violations.isEmpty()) {
            throw new ValidationExceptionDeliveryService("Invalid delivery information!");
        }
    }

    private void validatePositive(Integer value, String fieldName, List<String> violations) {
        if (value == null || value <= 0) {
            violations.add(fieldName + " must be positive.");
        }
    }

    private void validatePositive(BigDecimal value, String fieldName, List<String> violations) {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            violations.add(fieldName + " must be positive or zero.");
        }
    }

    private void validateFutureDate(Date deliveryDate, List<String> violations) {
        if (deliveryDate == null || deliveryDate.before(new Date())) {
            violations.add("Delivery Date must be in the future");
        }
    }

    private void validateString(String value, String fieldName, List<String> violations) {
        if (value == null || value.trim().isEmpty()) {
            violations.add(fieldName + " must not be empty.");
        }
    }

    private void validateOrderId(Long orderId, List<String> violations) {
        if (orderId == null || orderId <= 0) {
            violations.add("Order ID must be a positive number.");
        }
    }

    private void validateId(Long id, List<String> violations) {
        if (id == null || id <= 0) {
            violations.add("Delivery ID must be a positive number.");
        }
    }
}
