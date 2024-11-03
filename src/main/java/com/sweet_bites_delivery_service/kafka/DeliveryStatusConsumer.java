package com.sweet_bites_delivery_service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.service.OrderService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class DeliveryStatusConsumer {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryStatusConsumer.class);
    @Autowired
    private OrderService orderService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Map<String, Consumer<DeliveryDTO>> statusHandlers = new HashMap<>();

    @Autowired
    public DeliveryStatusConsumer() {
        statusHandlers.put("DELIVERED", this::handleDelivered);
        statusHandlers.put("FAILED", this::handleFailed);
        statusHandlers.put("IN_PROGRESS", this::handleInProgress);
    }

    @KafkaListener(topics = "delivery_status", groupId = "delivery-group")
    public void listenDeliveryStatus(ConsumerRecord<String, String> record) {
        Integer orderId = Integer.valueOf(record.key());
        String statusJson = record.value();
        logger.info("Received delivery status update for Order ID: {}, Status: {}", orderId, statusJson);

        try {
            DeliveryDTO deliveryDTO = objectMapper.readValue(statusJson, DeliveryDTO.class);
            orderService.updateOrderStatus(orderId, String.valueOf(deliveryDTO));

            statusHandlers.getOrDefault(deliveryDTO.getDeliveryStatus(), this::handleUnknown).accept(deliveryDTO);

        } catch (Exception e) {
            logger.error("Error processing delivery status for Order ID {}: {}", orderId, e.getMessage());
        }
    }

    private void handleDelivered(DeliveryDTO delivery) {
        logger.info("Order {} has been delivered.", delivery.getOrderId());
    }

    private void handleFailed(DeliveryDTO delivery) {
        logger.warn("Delivery for order {} failed. Initiating error handling.", delivery.getOrderId());
    }

    private void handleInProgress(DeliveryDTO delivery) {
        logger.info("Order {} is in progress.", delivery.getOrderId());
    }

    private void handleUnknown(DeliveryDTO delivery) {
        logger.warn("Unknown delivery status for order {}", delivery.getOrderId());
    }
}
