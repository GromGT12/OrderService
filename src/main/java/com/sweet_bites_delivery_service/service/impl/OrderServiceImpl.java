package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.exception.ValidationException;
import com.sweet_bites_delivery_service.repository.OrderRepository;
import com.sweet_bites_delivery_service.repository.mapper.OrderMapper;
import com.sweet_bites_delivery_service.repository.model.Order;
import com.sweet_bites_delivery_service.service.OrderService;
import com.sweet_bites_delivery_service.validator.OrderValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderValidator orderValidator, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        orderValidator.validate(orderDTO);
        return orderMapper.toOrderDTO(orderRepository.save(orderMapper.toOrder(orderDTO)));
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        return orderMapper.toOrderDTO(orderRepository.findById(orderId)
                .orElseThrow(() -> new ValidationException("Order not found with id: " + orderId)));
    }

    @Override
    @Transactional
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        orderValidator.validate(orderDTO);
        return orderMapper.toOrderDTO(orderRepository.save(orderMapper.toOrder(orderDTO)));
    }

    @Override
    @Transactional
    public void deleteOrderById(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByClientId(Integer clientId) {
        List<Order> orders = orderRepository.findByClientId(clientId);
        return orders.stream()
                .map(this::mapOrderToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByStatus(String status) {
        List<Order> orders = orderRepository.findByStatus(status);
        return orders.stream()
                .map(this::mapOrderToDTO)

                .collect(Collectors.toList());
    }

    private OrderDTO mapOrderToDTO(Order order) {
        return orderMapper.toOrderDTO(order);
    }

    @Override
    public int getOrderCountByStatus(String status) {
        return orderRepository.countByStatus(status);
    }

    @Override
    public double getTotalOrderAmountByClientId(Integer clientId) {
        return orderRepository.getTotalOrderAmountByClientId(clientId);
    }

    @Override
    public double getAverageOrderAmountByClientId(Integer clientId) {
        return orderRepository.getAverageOrderAmountByClientId(clientId);
    }
}
