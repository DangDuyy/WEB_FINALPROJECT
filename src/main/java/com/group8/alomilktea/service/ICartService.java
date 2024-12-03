package com.group8.alomilktea.service;

import com.group8.alomilktea.entity.Cart;

import java.util.List;

public interface ICartService {
    List<Cart> findByUserId(Integer userId);
}
