package com.group8.alomilktea.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
