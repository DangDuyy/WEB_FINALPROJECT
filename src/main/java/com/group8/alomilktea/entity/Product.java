package com.group8.alomilktea.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product") // Đảm bảo bảng trong DB có tên là "product"
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proId")
    private Integer proId;

    @Column(name = "name", nullable = false, length = 1000)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "stock", nullable = false, columnDefinition = "int default 1000")
    private Integer stock = 1000;

    @Column(name = "sale", nullable = false, columnDefinition = "int default 0")
    private Integer sale = 0;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "image_link", length = 1000)
    private String imageLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cateId", referencedColumnName = "cateId")
    private Category category; // Đảm bảo bạn có thuộc tính category trong Product

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", proId=" + proId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", sale=" + sale +
                ", price=" + price +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }

}
