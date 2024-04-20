package com.sweet_bites_delivery_service.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class DeliveryDTO {
    private Long id;
    private Long orderId;
    private Integer quantity;
    private BigDecimal totalPrice;
    private Date deliveryDate;
    private String deliveryStatus;
    private String deliveryAddress;
    private String deliveryMethod;

    public DeliveryDTO() {
    }

    public DeliveryDTO(Long id, Long orderId, Integer quantity, BigDecimal totalPrice, Date deliveryDate, String deliveryStatus, String deliveryAddress, String deliveryMethod) {
        this.id = id;
        this.orderId = orderId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
        this.deliveryStatus = deliveryStatus;
        this.deliveryAddress = deliveryAddress;
        this.deliveryMethod = deliveryMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryDTO that = (DeliveryDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(orderId, that.orderId) && Objects.equals(quantity, that.quantity) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(deliveryDate, that.deliveryDate) && Objects.equals(deliveryStatus, that.deliveryStatus) && Objects.equals(deliveryAddress, that.deliveryAddress) && Objects.equals(deliveryMethod, that.deliveryMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, quantity, totalPrice, deliveryDate, deliveryStatus, deliveryAddress, deliveryMethod);
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", deliveryDate=" + deliveryDate +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                '}';
    }
}