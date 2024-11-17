package com.sweet_bites_delivery_service.kafka;

import com.sweet_bites_delivery_service.redis.DeliveryStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DeliveryStatusProducer {
    private static final String TOPIC = "delivery_status";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    @Autowired
    private DeliveryStatusService deliveryStatusService;

    public void sendDeliveryStatus(String orderId, String statusJson) {
        // Сохранение статуса доставки в Redis
        deliveryStatusService.saveDeliveryStatus(orderId, statusJson);

        // Отправка сообщения в Kafka с использованием CompletableFuture
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC, orderId, statusJson);

        // Добавление обратного вызова для обработки результата отправки
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.printf("Delivery status sent successfully: %s%n", result.getRecordMetadata());
            } else {
                System.err.println("Failed to send delivery status: " + ex.getMessage());
            }
        });
    }
}
