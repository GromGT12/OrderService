package com.sweet_bites_delivery_service.validator;
import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeliveryValidator {

    public void validate(DeliveryDTO deliveryDTO) throws ValidationException {
        List<String> violations = new ArrayList<>();

        if (deliveryDTO.getOrderId() == null || deliveryDTO.getOrderId() <= 0) {
            violations.add("Order ID is invalid or missing");
        }
        if (deliveryDTO.getQuantity() == null || deliveryDTO.getQuantity() <= 0) {
            violations.add("Quantity is invalid or missing");
        }
        if (deliveryDTO.getTotalPrice() == null || deliveryDTO.getTotalPrice().compareTo(BigDecimal.ZERO) <= 0) {
            violations.add("Total price is invalid or missing");
        }
        if (deliveryDTO.getDeliveryDate() == null) {
            violations.add("Delivery date is missing");
        }
        if (deliveryDTO.getDeliveryAddress() == null || deliveryDTO.getDeliveryAddress().isEmpty()) {
            violations.add("Delivery address is missing");
        }
        if (deliveryDTO.getClientId() == null || deliveryDTO.getClientId() <= 0) {
            violations.add("Client ID is invalid or missing");
        }
        if (deliveryDTO.getClientName() == null || deliveryDTO.getClientName().isEmpty()) {
            violations.add("Client name is missing");
        }
        if (deliveryDTO.getClientAddress() == null || deliveryDTO.getClientAddress().isEmpty()) {
            violations.add("Client address is missing");
        }
        if (deliveryDTO.getDeliveryMethod() == null || deliveryDTO.getDeliveryMethod().isEmpty()) {
            violations.add("Delivery method is missing");
        }

        if (!violations.isEmpty()) {
            throw new ValidationException("Delivery validation failed", (Throwable) violations);
        }
    }
}
