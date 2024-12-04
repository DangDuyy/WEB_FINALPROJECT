package com.group8.alomilktea.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

//    @Column(name = "shipping_method")
//    private String shippingMethod;

    @Column(name = "status")
    private String status;

    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "FKdxew8n76x1bnoxjas0qxrlbq6"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "shipCid", referencedColumnName = "shipCid", foreignKey = @ForeignKey(name = "FK_Ship_Oder"))
    private ShipmentCompany shipmentCompany;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    // Constructor with fields
    public Order(String currency, String date, String paymentMethod, ShipmentCompany shipmentCompany, String status, Double total, User user) {
        this.currency = currency;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.shipmentCompany = shipmentCompany;
        this.status = status;
        this.total = total;
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
                ", shippingMethod='" + shipmentCompany + '\'' +
                ", status=" + status +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
