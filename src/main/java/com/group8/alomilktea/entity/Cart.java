package com.group8.alomilktea.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {

    @Id
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId",foreignKey = @ForeignKey(name = "FK_Cart_User"))
    private User user;  // Khóa ngoại tham chiếu đến bảng User

    @Id
    @ManyToOne
    @JoinColumn(name = "proId", referencedColumnName = "proId",foreignKey = @ForeignKey(name = "FK_Cart_product"))
    private Product product;  // Khóa ngoại tham chiếu đến bảng Product

    @Column(name = "quantity")
    private Integer quantity;

    // Constructors, getters, and setters


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
