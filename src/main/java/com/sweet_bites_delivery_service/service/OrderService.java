package com.sweet_bites_delivery_service.service;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {

    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(Integer orderId);

    Integer createOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(Integer orderId, OrderDTO orderDTO);

    void deleteOrderById(Integer orderId);

    void updateOrderStatus(Integer orderId, String newStatus);

    List<OrderDTO> getOrdersByClientId(Integer clientId);
}
