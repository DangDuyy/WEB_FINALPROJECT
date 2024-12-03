package com.group8.alomilktea.repository;

import com.group8.alomilktea.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query(value="select * from cart where user_id=?",nativeQuery = true)
    List<Cart> findByUserId(Integer userId);
}
