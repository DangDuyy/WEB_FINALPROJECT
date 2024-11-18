package com.group8.alomilktea.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "currency")
    private String currency;

    @Column(name = "date")
    private String date;

    @Column(name = "payment_method", columnDefinition = "varchar(255) default 'standard'")
    private String paymentMethod;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "status")
    private Integer status;

    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "FKdxew8n76x1bnoxjas0qxrlbq6"))
    private User user;

    // Default constructor
    public Order() {}

    // Constructor with fields
    public Order(String currency, String date, String paymentMethod, String shippingMethod, Integer status, Double total, User user) {
        this.currency = currency;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.status = status;
        this.total = total;
        this.user = user;
    }

    // Getters and setters
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", date='" + date + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", status=" + status +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
