package com.sweet_bites_delivery_service.validator;

import com.sweet_bites_delivery_service.dto.CartItemDTO;
import com.sweet_bites_delivery_service.exception.ValidationExceptionDeliveryService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

@Component
public class CartItemValidator {
    private final RabbitTemplate rabbitTemplate;

    public CartItemValidator(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void validateCartItem(CartItemDTO cartItemDTO) {
        List<String> violations = new ArrayList<>();
        boolean productExists = validateProductExists(cartItemDTO.getProductId());
        if (!productExists) {
            violations.add("Product with this ID does not exist.");
        }

        validateProductName(cartItemDTO.getProductName(), violations);
        validateQuantity(cartItemDTO.getQuantity(), violations);
        validatePrice(cartItemDTO.getPrice(), violations);

        if (!violations.isEmpty()) {
            throw new ValidationExceptionDeliveryService("CartItem validation failed", violations);
        }
    }

    private boolean validateProductExists(Long productId) {
        if (productId == null || productId <= 0) {
            return false;
        }

        CountDownLatch latch = new CountDownLatch(1);
        boolean[] result = new boolean[1];

        rabbitTemplate.convertAndSend("productQueue", productId);

        rabbitTemplate.setReplyTimeout(5000);
        Message response = rabbitTemplate.receive("productQueue.response");

        if (response != null) {
            result[0] = Boolean.parseBoolean(new String(response.getBody()));
        }

        latch.countDown();
        return result[0];
    }

    private void validateProductName(String productName, List<String> violations) {
        if (productName == null || productName.trim().isEmpty()) {
            violations.add("Product name must not be empty.");
        } else if (!Pattern.compile("^[a-zA-Z]+$").matcher(productName).matches()) {
            violations.add("Product name can contain only letters.");
        }
    }

    private void validateQuantity(int quantity, List<String> violations) {
        if (quantity <= 0) {
            violations.add("Quantity must be a positive integer.");
        }
    }

    private void validatePrice(double price, List<String> violations) {
        if (price <= 0) {
            violations.add("Price must be greater than zero.");
        }
    }
}
