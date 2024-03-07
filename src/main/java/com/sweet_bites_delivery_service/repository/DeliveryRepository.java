package com.sweet_bites_delivery_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<DeliveryRepository, Integer > {
    Optional<Object> findById(Long id);
}
