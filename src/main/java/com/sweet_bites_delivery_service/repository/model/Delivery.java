package com.sweet_bites_delivery_service.repository.model;

import java.util.Date;

public class Delivery {
    // Поля сущности Delivery
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double totalPrice;
    private Date deliveryDate;
    private String deliveryStatus;
    private String deliveryAddress;
    private Long clientId;
    private String clientName;
    private String clientAddress;
    private String deliveryMethod;

    // Геттеры и сеттеры
}