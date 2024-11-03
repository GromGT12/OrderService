package com.sweet_bites_delivery_service.kafka;
import com.sweet_bites_delivery_service.redis.DeliveryStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class DeliveryStatusProducer {
    private static final String TOPIC = "delivery_status";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private DeliveryStatusService deliveryStatusService;

    public void sendDeliveryStatus(String orderId, String statusJson) {
        deliveryStatusService.saveDeliveryStatus(orderId, statusJson);

        ListenableFuture<SendResult<String, String>> future = (ListenableFuture<SendResult<String, String>>) kafkaTemplate.send(TOPIC, orderId, statusJson);
        future.addCallback(
                result -> System.out.printf("Delivery status sent successfully: %s%n", result.getRecordMetadata()),
                ex -> System.err.println("Failed to send delivery status: " + ex.getMessage())
        );
    }
}
