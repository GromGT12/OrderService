package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.dto.OrderDTO;

import java.util.Date;
import java.util.List;

public interface DeliveryService {
    DeliveryDTO getDeliveryByOrderId(Long orderId);

    DeliveryDTO createDelivery(DeliveryDTO deliveryDTO);

    DeliveryDTO updateDelivery(DeliveryDTO deliveryDTO);

    DeliveryDTO deleteDeliveryByOrderId(Long orderId);

    List<DeliveryDTO> getDeliveriesByStatus(String deliveryStatus);

    List<DeliveryDTO> getDeliveriesByDateRange(Date startDate, Date endDate);

    int getDeliveryCountByStatus(String deliveryStatus);

    DeliveryDTO getDeliveryById(Long id);

    void deleteDelivery(Long id);

}
