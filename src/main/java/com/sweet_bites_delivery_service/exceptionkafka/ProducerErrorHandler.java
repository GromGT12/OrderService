package com.sweet_bites_delivery_service.exceptionkafka;

import com.sweet_bites_delivery_service.redis.DeliveryStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerErrorHandler {

    @Autowired
    private DeliveryStatusService deliveryStatusService;

    public void handleProducerError(String orderId, Object message, Throwable ex) {
        System.err.println("Producer error: " + ex.getMessage());

        deliveryStatusService.saveDeliveryStatus(orderId, "Error: " + ex.getMessage());
    }
}
