package com.sweet_bites_delivery_service.validator;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.dto.ShoppingCartDTO;
import com.sweet_bites_delivery_service.exception.ValidationExceptionDeliveryService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ShoppingCartValidator {
    public void validateShoppingCart(ShoppingCartDTO cartDTO) {

        List<String> violations = new ArrayList<>();
        validateUserId(cartDTO.getUserId(), violations);
        validateItems(cartDTO.getItems(), violations);
        validatePositive(cartDTO.getTotalPrice(), "Total Price", violations);
        validateDate(cartDTO.getCreatedAt(), "Created At", violations);
        validateDate(cartDTO.getUpdatedAt(), "Updated At", violations);
        validateString(cartDTO.getShippingAddress(), "Shipping Address", violations);
        validateString(cartDTO.getShippingMethod(), "Shipping Method", violations);
        validateString(cartDTO.getPaymentMethod(), "Payment Method", violations);

        if (!violations.isEmpty()) {
            throw new ValidationExceptionDeliveryService("Invalid shopping cart!", violations);
        }
    }

    private void validateUserId(Long userId, List<String> violations) {
        if (userId == null || userId <= 0) {
            violations.add("User ID must be positive.");
        }
    }

    private void validateItems(List<CartItemDTO> items, List<String> violations) {
        if (items == null || items.isEmpty()) {
            violations.add("Shopping cart must contain at least one item.");
        }
    }

    private void validatePositive(Number value, String fieldName, List<String> violations) {
        if (value == null || value.doubleValue() < 0) {
            violations.add(fieldName + " must be positive.");
        }
    }

    private void validateDate(Date date, String fieldName, List<String> violations) {
        if (date == null) {
            violations.add(fieldName + " must not be null.");
        }
    }

    private void validateString(String value, String fieldName, List<String> violations) {
        if (value == null || value.trim().isEmpty()) {
            violations.add(fieldName + " must not be empty.");
        }
    }

    public void validateAddCartItem(Long userId, Long productId, int quantity, BigDecimal price) {
    }
}


