package com.sweet_bites_delivery_service.repository.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<CartItem> items;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public ShoppingCart() {
    }

    public ShoppingCart(Long id, Long userId, List<CartItem> items, BigDecimal totalPrice) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", userId=" + userId +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

