package com.sweet_bites_delivery_service.repository;

import com.sweet_bites_delivery_service.repository.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    int countByStatus(String status);

    double getTotalOrderAmountByClientId(Integer clientId);

    double getAverageOrderAmountByClientId(Integer clientId);

    List<Order> findByClientId(Integer clientId);

    List<Order> findByStatus(String status);
}

