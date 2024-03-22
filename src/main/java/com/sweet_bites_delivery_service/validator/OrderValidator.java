package com.sweet_bites_delivery_service.validator;
import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class OrderValidator {

    private static final Pattern ONLY_LETTERS_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("^[a-zA-Z0-9\\s,-]+$");

    public void validateOrder(OrderDTO orderDTO) {
        List<String> violations = new ArrayList<>();

        validateClientId(orderDTO.getClientId(), violations);
        validateOrderDate(orderDTO.getOrderDate(), violations);
        validateStatus(orderDTO.getStatus(), violations);
        validateDeliveryAddress(orderDTO.getDeliveryAddress(), violations);

        if (!violations.isEmpty()) {
            throw new ValidationException("Provided order is invalid!", (Throwable) violations);
        }
    }

    private void validateClientId(Integer clientId, List<String> violations) {
        if (clientId == null) {
            violations.add("Client ID must not be null");
        }
    }

    private void validateOrderDate(Date orderDate, List<String> violations) {
        if (orderDate == null) {
            violations.add("Order date must not be null");
        }
    }

    private void validateStatus(String status, List<String> violations) {
        if (status == null || status.trim().isEmpty()) {
            violations.add("Order status must not be empty");
        }
    }

    private void validateDeliveryAddress(String address, List<String> violations) {
        if (address == null || address.trim().isEmpty()) {
            violations.add("Delivery address must not be empty");
        } else if (!ADDRESS_PATTERN.matcher(address).matches()) {
            violations.add("Delivery address must match the pattern: " + ADDRESS_PATTERN.pattern());
        }
    }

    public void validate(OrderDTO orderDTO) {
    }
}
