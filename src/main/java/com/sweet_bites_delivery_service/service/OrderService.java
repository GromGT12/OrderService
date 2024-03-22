package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);


    OrderDTO getOrderById(Integer orderId);


    OrderDTO updateOrder(OrderDTO orderDTO);


    void deleteOrderById(Integer orderId);


    List<OrderDTO> getAllOrders();


    List<OrderDTO> getOrdersByClientId(Integer clientId);


    List<OrderDTO> getOrdersByStatus(String status);


    int getOrderCountByStatus(String status);

    double getTotalOrderAmountByClientId(Integer clientId);


    double getAverageOrderAmountByClientId(Integer clientId);
}
