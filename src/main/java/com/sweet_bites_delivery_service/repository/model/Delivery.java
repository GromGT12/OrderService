package com.sweet_bites_delivery_service.repository.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "delivery_status")
    private String deliveryStatus;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "delivery_method")
    private String deliveryMethod;

    public Delivery() {
    }

    public Delivery(Long id, Order order, Integer quantity, BigDecimal totalPrice, Date deliveryDate, String deliveryStatus, String deliveryAddress, String deliveryMethod) {
        this.id = id;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id) && Objects.equals(order, delivery.order) && Objects.equals(quantity, delivery.quantity) && Objects.equals(totalPrice, delivery.totalPrice) && Objects.equals(deliveryDate, delivery.deliveryDate) && Objects.equals(deliveryStatus, delivery.deliveryStatus) && Objects.equals(deliveryAddress, delivery.deliveryAddress) && Objects.equals(deliveryMethod, delivery.deliveryMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, quantity, totalPrice, deliveryDate, deliveryStatus, deliveryAddress, deliveryMethod);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", order=" + order +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", deliveryDate=" + deliveryDate +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                '}';
    }
}
