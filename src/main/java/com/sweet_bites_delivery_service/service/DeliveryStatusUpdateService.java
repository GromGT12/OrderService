package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.exception.DeliveryNotFoundException;
import com.sweet_bites_delivery_service.model.Delivery;
import com.sweet_bites_delivery_service.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryStatusUpdateService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public void updateDeliveryStatus(Long deliveryId, String status) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (optionalDelivery.isPresent()) {
            Delivery delivery = optionalDelivery.get();
            delivery.setDeliveryStatus(status);
            deliveryRepository.save(delivery);
        } else {
            throw new DeliveryNotFoundException("Delivery ID not found: " + deliveryId);
        }
    }
}
