package com.sweet_bites_delivery_service.validator;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.exception.ValidationExceptionDeliveryService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DeliveryValidator {
    public void validatorDelivery(DeliveryDTO deliveryDTO) {

        List<String> violations = new ArrayList<>();
        validateId(deliveryDTO.getId(), violations);
        validateOrderId(deliveryDTO.getOrderId(), violations);
        validatePositive(deliveryDTO.getQuantity(), "Quantity", violations);
        validatePositive(deliveryDTO.getTotalPrice(), "Total price", violations);
        validateFutureDate(deliveryDTO.getDeliveryDate(), "Delivery Date", violations);
        validateString(deliveryDTO.getDeliveryAddress(), "Delivery Address", violations);
        validateString(deliveryDTO.getDeliveryMethod(), "Delivery Method", violations);

        if (!violations.isEmpty()) {
            throw new ValidationExceptionDeliveryService("Invalid delivery information!", violations);
        }
    }

    private void validateString(String value, String fieldName, List<String> violations) {
        if (value == null || value.trim().isEmpty()) {
            violations.add(fieldName + " must not be empty.");

        }
    }

    private void validateFutureDate(Date deliveryDate, String fieldName, List<String> violations) {
        if (deliveryDate == null || deliveryDate.before(new Date())) {
            violations.add(fieldName + " must be in the future");
        }
    }

    private void validatePositive(BigDecimal value, String fieldName, List<String> violations) {
        if (value == null) {
            violations.add(fieldName + " must not be null.");
        } else if (value.compareTo(BigDecimal.ZERO) < 0) {
            violations.add(fieldName + " must be positive or zero.");
        }
    }

    private void validateOrderId(Long orderId, List<String> violations) {
        if (orderId == null || orderId <= 0) {
            violations.add("Order ID must be a positive number");
        }
    }

    private void validateId(Long id, List<String> violations) {
        if (id == null || id <= 0) {
            violations.add("Delivery ID" + "must be a positive number");
        }
    }
}
