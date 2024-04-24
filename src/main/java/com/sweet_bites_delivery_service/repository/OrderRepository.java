package com.sweet_bites_delivery_service.repository;

import com.sweet_bites_delivery_service.repository.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByClientId(Integer clientId);
}
