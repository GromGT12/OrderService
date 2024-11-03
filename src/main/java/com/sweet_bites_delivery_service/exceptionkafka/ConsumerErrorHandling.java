package com.sweet_bites_delivery_service.exceptionkafka;
import com.sweet_bites_delivery_service.redis.DeliveryStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConsumerErrorHandling {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ProducerErrorHandler producerErrorHandler;
    private final DeliveryStatusService deliveryStatusService;

    private final Integer maxRetryAttempts = 3;
    private final Long retryInterval = 1000L;

    private final Map<String, Integer> retryCountMap = new HashMap<>();

    @Autowired
    public ConsumerErrorHandling(KafkaTemplate<String, Object> kafkaTemplate,
                                 ProducerErrorHandler producerErrorHandler,
                                 DeliveryStatusService deliveryStatusService) {
        this.kafkaTemplate = kafkaTemplate;
        this.producerErrorHandler = producerErrorHandler;
        this.deliveryStatusService = deliveryStatusService;
    }

    public void handleError(String orderId, Object message) {
        int retryCount = retryCountMap.getOrDefault(orderId, 0);

        if (retryCount < maxRetryAttempts) {
            retryCountMap.put(orderId, retryCount + 1);
            System.out.println("Retrying order " + orderId + " (Attempt " + retryCount + ")");

            try {
                Thread.sleep(retryInterval);

                ListenableFuture<SendResult<String, Object>> future = (ListenableFuture<SendResult<String, Object>>) kafkaTemplate.send("order-topic", orderId, message);
                future.addCallback(
                        result -> {
                            deliveryStatusService.saveDeliveryStatus(orderId, "Success");
                            retryCountMap.remove(orderId);
                        },
                        ex -> {
                            producerErrorHandler.handleProducerError(orderId, message, ex);
                        }
                );

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Order " + orderId + " failed after max attempts. Sending to DLQ.");
            kafkaTemplate.send("dead-letter-queue", orderId, message);
            retryCountMap.remove(orderId);
        }
    }
}
