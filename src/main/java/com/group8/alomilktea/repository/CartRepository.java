package com.group8.alomilktea.repository;

import com.group8.alomilktea.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query(value="select * from cart where user_id=?",nativeQuery = true)
    List<Cart> findByUserId(Integer userId);
    @Query(value="select * from cart where user_id=? and pro_id=?",nativeQuery = true)
    List<Cart> findByUserIdAndProid(Integer userId,Integer proId);
}
