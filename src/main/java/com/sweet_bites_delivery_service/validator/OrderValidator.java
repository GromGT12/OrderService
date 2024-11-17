package com.sweet_bites_delivery_service.validator;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.exception.ValidationExceptionDeliveryService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

@Component
public class OrderValidator {

    private static final Pattern ONLY_LETTERS_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d+");

    private final RabbitTemplate rabbitTemplate;

    public OrderValidator(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void validateOrder(OrderDTO orderDTO) {

        List<String> violations = new ArrayList<>();
        validateId(Math.toIntExact(orderDTO.getId()), violations);
        validateClientId(orderDTO.getClientId(), violations);
        validateOrderDate(orderDTO.getOrderDate(), violations);
        validateStringOnlyLetters(orderDTO.getStatus(), "Status", violations);
        validateStringOnlyLetters(orderDTO.getDeliveryAddress(), "Delivery Address", violations);
        validateStringOnlyLetters(orderDTO.getPaymentStatus(), "Payment Status", violations);

        if (!violations.isEmpty()) {
            throw new ValidationExceptionDeliveryService("Provided order is invalid!");
        }
    }

    private void validateId(Integer id, List<String> violations) {
        if (id == null || id <= 0) {
            violations.add("Order ID must be a positive integer.");
        }
    }

    private void validateClientId(Integer clientId, List<String> violations) {
        if (clientId == null || clientId <= 0) {
            violations.add("Client ID must be a positive integer.");
        } else {
            if (!isClientExists(clientId)) {
                violations.add("Client with ID " + clientId + " does not exist.");
            }
        }
    }

    private boolean isClientExists(Integer clientId) {
        final boolean[] result = new boolean[1];
        final CountDownLatch latch = new CountDownLatch(1);

        rabbitTemplate.convertAndSend("clientQueue", clientId, message -> {
            result[0] = Boolean.parseBoolean(new String(message.getBody()));
            latch.countDown();
            return message;
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return result[0];
    }

    private void validateOrderDate(Date orderDate, List<String> violations) {
        if (orderDate == null) {
            violations.add("Order date must not be null.");
        }
    }

    private void validateStringOnlyLetters(String value, String fieldName, List<String> violations) {
        if (value == null || value.trim().isEmpty()) {
            violations.add(fieldName + " must not be empty.");
        }
        assert value != null;
        if (!ONLY_LETTERS_PATTERN.matcher(value).matches()) {
            violations.add(fieldName + " must contain only letters.");
        }
    }

    private void validateEmailPattern(String value, String fieldName, List<String> violations) {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            violations.add(fieldName + " is invalid.");
        }
    }

    private void validatePhonePattern(String value, String fieldName, List<String> violations) {
        if (value == null || !PHONE_NUMBER_PATTERN.matcher(value).matches()) {
            violations.add(fieldName + " is invalid.");
        }
    }
}
