package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.model.Order;
import com.sweet_bites_delivery_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessingService {
    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
