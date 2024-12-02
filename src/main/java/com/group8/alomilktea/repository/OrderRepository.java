package com.group8.alomilktea.repository;

import com.group8.alomilktea.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUser_UserId(int userId);

    @Query(nativeQuery = true, value = "SELECT * FROM orders ORDER BY date DESC")
    Page<Order> findAllCustom(Pageable pageable);
}
