package com.sweet_bites_delivery_service.repository;

import com.sweet_bites_delivery_service.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findByDeliveryStatus(String deliveryStatus);

    Delivery findByOrderId(Long orderId);

    @Query(value = "SELECT * FROM delivery WHERE delivery_status = :status", nativeQuery = true)
    List<Delivery> findDeliveriesByStatus(@Param("status") String status);

    List<Delivery> findByDeliveryDateBetween(Date startDate, Date endDate);

    int countByDeliveryStatus(String deliveryStatus);


}
