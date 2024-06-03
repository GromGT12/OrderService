package com.sweet_bites_delivery_service.controller;

import com.sweet_bites_delivery_service.dto.OrderDTO;
import com.sweet_bites_delivery_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Integer orderId) {
        OrderDTO order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Integer> createOrder(@RequestBody OrderDTO orderDTO) {
        Integer orderId = orderService.createOrder(orderDTO);
        return ResponseEntity.ok(orderId);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Integer orderId, @RequestBody OrderDTO orderDTO) {
        OrderDTO updatedOrder = orderService.updateOrder(orderId, orderDTO);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Integer orderId) {
        orderService.deleteOrderById(orderId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<Void> updateOrderStatus(@PathVariable Integer orderId, @RequestParam String newStatus) {
        orderService.updateOrderStatus(orderId, newStatus);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByClientId(@PathVariable Integer clientId) {
        List<OrderDTO> orders = orderService.getOrdersByClientId(clientId);
        return ResponseEntity.ok(orders);
    }
}
