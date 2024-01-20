package com.sweet_bites_order_service.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderDetailsDTO {
    private Integer id;
    private ProductDTO productDTO;
    private Integer quantity;
    private BigDecimal totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsDTO that = (OrderDetailsDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(productDTO, that.productDTO) && Objects.equals(quantity, that.quantity) && Objects.equals(totalPrice, that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productDTO, quantity, totalPrice);
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "id=" + id +
                ", productDTO=" + productDTO +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}