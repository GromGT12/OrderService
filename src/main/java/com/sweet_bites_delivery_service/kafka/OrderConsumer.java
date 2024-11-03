package com.sweet_bites_delivery_service.kafka;

import com.sweet_bites_delivery_service.redis.DeliveryStatusService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @Autowired
    private DeliveryStatusService deliveryStatusService;

    @KafkaListener(topics = "orders", groupId = "order-consumer-group")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.printf("Received order. Key: %s, Value: %s%n", record.key(), record.value());

        Object deliveryStatus = deliveryStatusService.getDeliveryStatus(record.key());
        System.out.printf("Delivery status for order %s: %s%n", record.key(), deliveryStatus);
    }
}
