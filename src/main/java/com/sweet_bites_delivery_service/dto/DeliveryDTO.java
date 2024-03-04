package com.sweet_bites_delivery_service.dto;

import java.util.Date;
import java.util.Objects;

public class DeliveryDTO {
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

    public DeliveryDTO(Long id, Long orderId, Long productId, Integer quantity, Double totalPrice, Date deliveryDate, String deliveryStatus, String deliveryAddress, Long clientId, String clientName, String clientAddress, String deliveryMethod) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
        this.deliveryStatus = deliveryStatus;
        this.deliveryAddress = deliveryAddress;
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
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
        return Objects.equals(id, that.id) && Objects.equals(orderId, that.orderId) && Objects.equals(productId, that.productId) && Objects.equals(quantity, that.quantity) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(deliveryDate, that.deliveryDate) && Objects.equals(deliveryStatus, that.deliveryStatus) && Objects.equals(deliveryAddress, that.deliveryAddress) && Objects.equals(clientId, that.clientId) && Objects.equals(clientName, that.clientName) && Objects.equals(clientAddress, that.clientAddress) && Objects.equals(deliveryMethod, that.deliveryMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, productId, quantity, totalPrice, deliveryDate, deliveryStatus, deliveryAddress, clientId, clientName, clientAddress, deliveryMethod);
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", deliveryDate=" + deliveryDate +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                '}';
    }
}
