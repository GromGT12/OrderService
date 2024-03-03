package com.sweet_bites_delivery_service.controller;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDTO> getDeliveryById(@PathVariable Long id) {
        // Реализация метода для получения информации о доставке по идентификатору
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<Void> createDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        // Реализация метода для создания новой доставки
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDelivery(@PathVariable Long id, @RequestBody DeliveryDTO deliveryDTO) {
        // Реализация метода для обновления информации о доставке
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
        // Реализация метода для удаления доставки
        return null;
    }
}
