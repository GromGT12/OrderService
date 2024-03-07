package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import org.springframework.transaction.annotation.Transactional;

public interface DeliveryService {
    DeliveryDTO getDeliveryById(Integer id);

    @Transactional(readOnly = true)
    DeliveryDTO getDeliveryById(Long id);

    void createDelivery(DeliveryDTO deliveryDTO);

    void updateDelivery(DeliveryDTO deliveryDTO);

    void deleteDelivery(Integer id);

    @Transactional
    void updateDelivery(Long id, DeliveryDTO deliveryDTO);

    @Transactional
    void deleteDelivery(Long id);
}
