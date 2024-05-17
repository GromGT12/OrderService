package com.sweet_bites_delivery_service.controller;

import com.sweet_bites_delivery_service.dto.DeliveryDTO;
import com.sweet_bites_delivery_service.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/{id}")
    public DeliveryDTO getDeliveryById(@PathVariable Integer id) {
        return deliveryService.getDeliveryById(id);
    }

    @PostMapping("/")
    public DeliveryDTO createDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        return deliveryService.createDelivery(deliveryDTO);
    }

    @PutMapping("/{id}")
    public DeliveryDTO updateDelivery(@PathVariable Integer id, @RequestBody DeliveryDTO deliveryDTO) {
        deliveryDTO.setId(Long.valueOf(id));
        return deliveryService.updateDelivery(deliveryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDelivery(@PathVariable Integer id) {
        deliveryService.deleteDelivery(id);
    }

    @GetMapping("/byClientId/{clientId}")
    public List<DeliveryDTO> getDeliveriesByClientId(@PathVariable Integer clientId) {
        return deliveryService.getDeliveriesByClientId(clientId);
    }

    @GetMapping("/byStatus/{status}")
    public List<DeliveryDTO> getDeliveriesByStatus(@PathVariable String status) {
        return deliveryService.getDeliveriesByStatus(status);
    }

    @GetMapping("/byDateRange")
    public List<DeliveryDTO> getDeliveriesByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        return deliveryService.getDeliveriesByDateRange(startDate, endDate);
    }

    @GetMapping("/byProductId/{productId}")
    public List<DeliveryDTO> getDeliveriesByProductId(@PathVariable Integer productId) {
        return deliveryService.getDeliveriesByProductId(productId);
    }

    @GetMapping("/count/byStatus/{status}")
    public int getDeliveryCountByStatus(@PathVariable String status) {
        return deliveryService.getDeliveryCountByStatus(status);
    }
}
