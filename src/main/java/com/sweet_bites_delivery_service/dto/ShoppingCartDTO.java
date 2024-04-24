package com.sweet_bites_delivery_service.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ShoppingCartDTO {
    private Long userId;
    private List<CartItemDTO> items;
    private BigDecimal totalPrice;
    private Date createdAt;
    private Date updatedAt;
    private String status;
    private String shippingAddress;
    private String shippingMethod;
    private String paymentMethod;
    private String couponCode;

    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(Long userId, List<CartItemDTO> items, BigDecimal totalPrice, Date createdAt, Date updatedAt, String status, String shippingAddress, String shippingMethod, String paymentMethod, String couponCode) {
        this.userId = userId;
        this.items = items;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.shippingMethod = shippingMethod;
        this.paymentMethod = paymentMethod;
        this.couponCode = couponCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartDTO that = (ShoppingCartDTO) o;
        return Objects.equals(userId, that.userId) && Objects.equals(items, that.items) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(status, that.status) && Objects.equals(shippingAddress, that.shippingAddress) && Objects.equals(shippingMethod, that.shippingMethod) && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(couponCode, that.couponCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, items, totalPrice, createdAt, updatedAt, status, shippingAddress, shippingMethod, paymentMethod, couponCode);
    }

    @Override
    public String toString() {
        return "ShoppingCartDTO{" +
                "userId=" + userId +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status='" + status + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", couponCode='" + couponCode + '\'' +
                '}';
    }
}
