package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.repository.OrderRepository;
import com.sweet_bites_delivery_service.repository.mappers.OrderMapper;
import com.sweet_bites_delivery_service.repository.model.Order;
import com.sweet_bites_delivery_service.service.OrderService;
import com.sweet_bites_delivery_service.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderValidator orderValidator, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderDTO)
                .toList();
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.map(orderMapper::toOrderDTO).orElse(null);
    }

    @Override
    @Transactional
    public Integer createOrder(OrderDTO orderDTO) {
        orderValidator.validateOrder(orderDTO);
        Order order = orderMapper.toOrder(orderDTO);
        orderRepository.save(order);
        return order.getId().intValue();
    }

    @Override
    public OrderDTO updateOrder(Integer orderId, OrderDTO orderDTO) {
        Optional<Order> existingOrder = orderRepository.findById(orderId);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            orderMapper.updateOrderFromDTO(order, orderDTO);
            orderRepository.save(order);
        }
        return null;
    }

    @Override
    public void deleteOrderById(Integer orderId) {
        orderRepository.deleteById(orderId);

    }

    @Override
    public void updateOrderStatus(Integer orderId, String newStatus) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            order.get().setStatus(newStatus);
            orderRepository.save(order.get());
        }
    }

    @Override
    public List<OrderDTO> getOrdersByClientId(Integer clientId) {

        return orderRepository.findByClientId(clientId).stream()
                .map(orderMapper::toOrderDTO)
                .toList();
    }
}
