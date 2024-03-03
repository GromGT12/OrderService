package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.repository.DeliveryRepository;
import com.sweet_bites_delivery_service.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public DeliveryDTO getDeliveryById(Long id) {
        // Реализация метода для получения информации о доставке по идентификатору
        return null;
    }

    @Override
    public void createDelivery(DeliveryDTO deliveryDTO) {
        // Реализация метода для создания новой доставки
    }

    @Override
    public void updateDelivery(DeliveryDTO deliveryDTO) {
        // Реализация метода для обновления информации о доставке
    }

    @Override
    public void deleteDelivery(Long id) {
        // Реализация метода для удаления доставки
    }
}
