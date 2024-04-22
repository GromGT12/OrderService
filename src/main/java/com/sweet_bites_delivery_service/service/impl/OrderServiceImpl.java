package com.sweet_bites_delivery_service.service.impl;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.repository.OrderRepository;
import com.sweet_bites_delivery_service.repository.mappers.OrderMapper;
import com.sweet_bites_delivery_service.service.OrderService;
import com.sweet_bites_delivery_service.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return null;
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        return null;
    }

    @Override
    @Transactional
    public Integer createOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO updateOrder(Integer orderId, OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void deleteOrderById(Integer orderId) {

    }

    @Override
    public void updateOrderStatus(Integer orderId, String newStatus) {

    }

    @Override
    public List<OrderDTO> getOrdersByClientId(Integer clientId) {
        return null;
    }
}
/*

    @Override
    public List<OrderDTO> getAllOrders() {
        // Получить все заказы из репозитория и преобразовать в DTO
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderDTO)
                .toList();
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        // Найти заказ по ID, преобразовать в DTO
        Optional<Order> order = orderRepository.findById(orderId);
        return order.map(orderMapper::toOrderDTO).orElse(null);
    }

    @Override
    @Transactional
    public Integer createOrder(OrderDTO orderDTO) {
        // Проверить корректность заказа с помощью валидатора
        orderValidator.validate(orderDTO);

        // Преобразовать DTO в Order и сохранить в репозитории
        Order order = orderMapper.toOrder(orderDTO);
        orderRepository.save(order);
        return order.getId();
    }

    @Override
    public OrderDTO updateOrder(Integer orderId, OrderDTO orderDTO) {
        // Проверить существование заказа по ID
        Optional<Order> existingOrder = orderRepository.findById(orderId);

        if (existingOrder.isPresent()) {
            // Обновить заказ и преобразовать в DTO
            Order order = existingOrder.get();
            orderMapper.updateOrderFromDTO(order, orderDTO);
            orderRepository.save(order);

            return orderMapper.toOrderDTO(order);
        }

        return null;
    }

    @Override
    public void deleteOrderById(Integer orderId) {
        // Удалить заказ по ID
        orderRepository.deleteById(orderId);
    }

    @Override
    public void updateOrderStatus(Integer orderId, String newStatus) {
        // Обновить статус заказа
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            order.get().setStatus(newStatus);
            orderRepository.save(order.get());
        }
    }

    @Override
    public List<OrderDTO> getOrdersByClientId(Integer clientId) {
        // Найти все заказы клиента по ID клиента, затем преобразовать в DTO
        return orderRepository.findByClientId(clientId).stream()
                .map(orderMapper::toOrderDTO)
                .toList();
    }
}
 */