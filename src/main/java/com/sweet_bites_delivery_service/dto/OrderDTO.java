package com.sweet_bites_delivery_service.dto;

import java.util.Date;
import java.util.Objects;

public class OrderDTO {
    private Integer id;
    private Integer clientId;
    private Date orderDate;
    private String status;
    private String deliveryAddress;
    private String paymentStatus;

    public OrderDTO() {
    }

    public OrderDTO(Integer id, Integer clientId, Date orderDate, String status, String deliveryAddress, String paymentStatus) {
        this.id = id;
        this.clientId = clientId;
        this.orderDate = orderDate;
        this.status = status;
        this.deliveryAddress = deliveryAddress;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) && Objects.equals(clientId, orderDTO.clientId) && Objects.equals(orderDate, orderDTO.orderDate) && Objects.equals(status, orderDTO.status) && Objects.equals(deliveryAddress, orderDTO.deliveryAddress) && Objects.equals(paymentStatus, orderDTO.paymentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, orderDate, status, deliveryAddress, paymentStatus);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}