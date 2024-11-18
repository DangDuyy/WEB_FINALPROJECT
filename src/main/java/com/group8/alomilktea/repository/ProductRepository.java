package com.group8.alomilktea.repository;

import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
