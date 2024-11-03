package com.sweet_bites_delivery_service.kafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public OrderProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(String orderId, String orderJson) {
        CompletableFuture<SendResult<String, String>> future = (CompletableFuture<SendResult<String, String>>) kafkaTemplate.send("orders", orderId, orderJson);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.err.println("Failed to send order: " + ex.getMessage());
            } else {
                System.out.printf("Order sent successfully. Topic: %s, Partition: %d, Offset: %d%n",
                        result.getRecordMetadata().topic(), result.getRecordMetadata().partition(), result.getRecordMetadata().offset());
            }
        });
    }
}
