package com.group8.alomilktea.service.impl;

import com.group8.alomilktea.entity.Cart;
import com.group8.alomilktea.repository.CartRepository;
import com.group8.alomilktea.service.ICartService;

import java.util.List;

public class CartServiceImpl implements ICartService {
    private CartRepository cartRepository;
    @Override
    public List<Cart> findByUserId(Integer userId) {
        return cartRepository.findByUserId(userId);
    }
}
