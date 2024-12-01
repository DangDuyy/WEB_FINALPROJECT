package com.group8.alomilktea.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_detail") // Đảm bảo bảng trong DB có tên là "product"
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class  ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proDId")
    private Integer proDId;

    @Column(name = "size")
    private Integer size;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "proId", referencedColumnName = "proId", foreignKey = @ForeignKey(name = "FK_Product_ProducDelail"))
    private Product product;
}
