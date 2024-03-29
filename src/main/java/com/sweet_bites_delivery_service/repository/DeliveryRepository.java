package com.sweet_bites_delivery_service.repository;

import com.sweet_bites_delivery_service.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    List<Delivery> findByDeliveryStatus(String deliveryStatus);

    List<Delivery> findByDeliveryAddress(String deliveryAddress);

    Delivery findByOrderId(Integer orderId);

    @Query(value = "SELECT * FROM delivery WHERE delivery_status = :status", nativeQuery = true)
    List<Delivery> findDeliveriesByStatus(@Param("status") String status);

    List<Delivery> findByDeliveryDateBetween(Date startDate, Date endDate);

    List<Delivery> findByProductId(Integer productId);

    int countByClientId(Integer clientId);

    int countByDeliveryStatus(String deliveryStatus);

    List<Delivery> findByClientId(Integer clientId);
}
