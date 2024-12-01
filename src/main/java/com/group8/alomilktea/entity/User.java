package com.group8.alomilktea.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "[user]") // Changed to "users" to avoid conflicts with SQL reserved keyword
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "fullName", length = 255)
    private String fullName;

    @Column(name = "email", length = 255, unique = true, nullable = true)
    private String email;

    @Column(name = "phone", length = 255, unique = true, nullable = true)
    private String phone;

    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "is_admin", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isAdmin; // Use Boolean if you need null support, or boolean for non-null values

    @Column(name = "active", columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean active;

    @Column(name = "password_hash", length = 255)
    private String passwordHash;

    @Column(name = "password_salt", length = 255)
    private String passwordSalt;

    @Column(name = "username", length = 255, unique = true)
    private String username;

    @Column(name = "code", length = 255)
    private String code;

    @Column(name = "is_enabled", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean isEnabled; // Use BIT(1) for boolean-like values in MySQL

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles", // "users_roles" is the join table to associate users with roles
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Rating> ratings;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ShipmentCompany shipmentCompany;

}
