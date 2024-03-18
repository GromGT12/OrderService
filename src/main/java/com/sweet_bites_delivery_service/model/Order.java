package com.sweet_bites_delivery_service.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "payment_status")
    private String paymentStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Delivery> deliveries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(clientId, order.clientId) && Objects.equals(orderDate, order.orderDate) && Objects.equals(totalPrice, order.totalPrice) && Objects.equals(status, order.status) && Objects.equals(deliveryAddress, order.deliveryAddress) && Objects.equals(paymentStatus, order.paymentStatus) && Objects.equals(deliveries, order.deliveries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, orderDate, totalPrice, status, deliveryAddress, paymentStatus, deliveries);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", deliveries=" + deliveries +
                '}';
    }
}
