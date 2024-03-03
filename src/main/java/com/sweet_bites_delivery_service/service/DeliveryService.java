package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;

public interface DeliveryService {
    DeliveryDTO getDeliveryById(Long id);

    void createDelivery(DeliveryDTO deliveryDTO);

    void updateDelivery(DeliveryDTO deliveryDTO);

    void deleteDelivery(Long id);
}
