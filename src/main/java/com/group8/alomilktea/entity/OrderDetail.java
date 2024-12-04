package com.group8.alomilktea.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_detail")
@Data

public class OrderDetail {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", foreignKey = @ForeignKey(name = "FK_OrderDetail_Order"))
    private Order order; // Liên kết với Order

    @Id
    @ManyToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id", foreignKey = @ForeignKey(name = "FK_OrderDetail_Product"))
    private Product product; // Liên kết với Product

//    @Column(name = "discount", nullable = false)
//    private float discount;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    // Constructors, getters, and setters

    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
