package com.sweet_bites_delivery_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class DeliveryStatusConsumer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public DeliveryStatusConsumer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendDeliveryStatus(String orderId, String statusJson) {
        // Отправка сообщения в Kafka
        ListenableFuture<SendResult<String, String>> future = (ListenableFuture<SendResult<String, String>>) kafkaTemplate.send("delivery_status", orderId, statusJson);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                // Обработка успешной отправки
                System.out.println("Message sent successfully: " + result.getProducerRecord());
            }

            @Override
            public void onFailure(Throwable ex) {
                // Обработка ошибки отправки
                System.err.println("Failed to send message: " + ex.getMessage());
            }
        });
    }
}
