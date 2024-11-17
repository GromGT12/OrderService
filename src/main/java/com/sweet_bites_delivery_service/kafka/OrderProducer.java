package com.sweet_bites_delivery_service.kafka;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.redis.DeliveryStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class OrderProducer {

    private static final String ORDER_TOPIC = "order-topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private DeliveryStatusService deliveryStatusService;

    public void sendOrder(String orderId, OrderDTO orderDTO) {
        // Отправка сообщения с заказом в Kafka
        CompletableFuture<SendResult<String, Object>> future = (CompletableFuture<SendResult<String, Object>>) kafkaTemplate.send(ORDER_TOPIC, orderId, orderDTO);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.err.println("Failed to send order for Order ID: " + orderId);
                deliveryStatusService.saveDeliveryStatus(orderId, "ORDER_FAILED");
            } else {
                System.out.printf("Order sent successfully for Order ID: %s%n", orderId);
                deliveryStatusService.saveDeliveryStatus(orderId, "ORDER_SENT");
            }
        });
    }
}