package com.sweet_bites_delivery_service.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CompletableFuture;

@Service
public class DeliveryStatusConsumer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public DeliveryStatusConsumer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public CompletableFuture<SendResult<String, String>> sendDeliveryStatus(String orderId, String statusJson) {
        ProducerRecord<String, String> record = new ProducerRecord<>("delivery_status", orderId, statusJson);
        ListenableFuture<SendResult<String, String>> listenableFuture = (ListenableFuture<SendResult<String, String>>) kafkaTemplate.send(record);

        CompletableFuture<SendResult<String, String>> completableFuture = new CompletableFuture<>();

        listenableFuture.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                completableFuture.complete(result);
            }

            @Override
            public void onFailure(Throwable ex) {
                completableFuture.completeExceptionally(ex);
            }
        });

        return completableFuture;
    }
}
