package com.group8.alomilktea.service;

import com.group8.alomilktea.entity.Cart;

import java.util.List;

public interface ICartService {
    List<Cart> findByUserId(Integer userId);
    List<Cart> findByUserIdAndProid(Integer userId,Integer proId);
    <S extends Cart> S save(S entity);
}
