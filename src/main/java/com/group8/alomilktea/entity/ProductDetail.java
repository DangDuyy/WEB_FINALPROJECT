package com.group8.alomilktea.entity;

import com.group8.alomilktea.common.enums.ProductAttribute;
import jakarta.persistence.*;
import lombok.*;

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
    @Enumerated(EnumType.STRING)
    private ProductAttribute size;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "proId", referencedColumnName = "proId", foreignKey = @ForeignKey(name = "FK_Product_ProducDelail"))
    @ToString.Exclude // Bỏ trường này khi gọi toString()
    private Product product;
}
