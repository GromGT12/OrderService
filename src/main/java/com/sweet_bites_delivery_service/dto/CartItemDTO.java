package com.sweet_bites_delivery_service.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class CartItemDTO {
    private Long productId;
    private String productName;
    private Integer quantity;
    private BigDecimal price;
    private Long userId;

    public CartItemDTO() {
    }

    public CartItemDTO(Long productId, String productName, int quantity, BigDecimal price, Long userId) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemDTO that = (CartItemDTO) o;
        return quantity == that.quantity && Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName) && Objects.equals(price, that.price) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, quantity, price, userId);
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", userId=" + userId +
                '}';
    }
}
