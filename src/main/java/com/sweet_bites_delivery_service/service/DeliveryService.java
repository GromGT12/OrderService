package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;

import java.util.Date;
import java.util.List;

public interface DeliveryService {
    DeliveryDTO getDeliveryByOrderId(Integer orderId);

    DeliveryDTO createDelivery(DeliveryDTO deliveryDTO);

    DeliveryDTO updateDelivery(DeliveryDTO deliveryDTO);

    DeliveryDTO deleteDeliveryByOrderId(Integer orderId);

    List<DeliveryDTO> getDeliveriesByClientId(Integer clientId);

    List<DeliveryDTO> getDeliveriesByStatus(String deliveryStatus);

    List<DeliveryDTO> getDeliveriesByDateRange(Date startDate, Date endDate);

    List<DeliveryDTO> getDeliveriesByProductId(Integer productId);

    int getDeliveryCountByClientId(Integer clientId);

    int getDeliveryCountByStatus(String deliveryStatus);

    DeliveryDTO getDeliveryById(Long id);

    void deleteDelivery(Long id);
}

