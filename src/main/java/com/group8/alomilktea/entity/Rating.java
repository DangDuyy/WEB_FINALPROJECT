package com.group8.alomilktea.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingId")
    private Integer ratingId;

    @Id
    @ManyToOne
    @JoinColumn(name="userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="productId", nullable = false, foreignKey = @ForeignKey(name = "FK_Rating_Product"))
    private Product product;

    @Column(name = "content", length = 2000)
    private String content;

    @Column(name = "platform", length = 255)
    private String platform;

    @Column(name = "rate")
    private Integer rate;


    @Column(name = "date", length = 255)
    private String date;
}
