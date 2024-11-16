package com.group8.alomilktea.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_detail")

public class OrderDetail {

    @Id
    @Column(name = "order_id")
    private int orderId;

    @Id
    @Column(name = "pro_id")
    private int productId;

    @Column(name = "discount", nullable = false)
    private float discount;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    // Constructors, getters, and setters

    public OrderDetail() {
    }

    public OrderDetail(int orderId, int productId, float discount, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.discount = discount;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
