package com.group8.alomilktea.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cateId")
    private int cateId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "logo")
    private String logo;

    // Default constructor
    public Category() {}

    // Constructor with parameters
    public Category(String name, String logo) {
        this.name = name;
        this.logo = logo;
    }

    // Getters and setters
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
