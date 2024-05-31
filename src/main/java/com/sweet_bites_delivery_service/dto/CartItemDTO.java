package com.sweet_bites_delivery_service.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class CartItemDTO {
    private Long id;
    private Long shoppingCartId;
    private Long productId;
    private String productName;
    private Integer quantity;
    private BigDecimal price;

    public CartItemDTO(Long userId, Object o, int i, BigDecimal zero) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemDTO that = (CartItemDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(shoppingCartId, that.shoppingCartId) && Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName) && Objects.equals(quantity, that.quantity) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shoppingCartId, productId, productName, quantity, price);
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "id=" + id +
                ", shoppingCartId=" + shoppingCartId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

