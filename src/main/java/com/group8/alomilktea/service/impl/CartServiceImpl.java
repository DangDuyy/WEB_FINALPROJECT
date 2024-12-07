package com.group8.alomilktea.service.impl;

import com.group8.alomilktea.entity.Cart;
import com.group8.alomilktea.repository.CartRepository;
import com.group8.alomilktea.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    private CartRepository cartRepository;
    @Autowired
    CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> findByUserId(Integer userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public List<Cart> findByUserIdAndProid(Integer userId, Integer proId) {
        return cartRepository.findByUserIdAndProid(userId, proId);
    }
    @Override
    public void deleteAll() {
        cartRepository.deleteAll();
    }

    @Override
    public void clearCart(Integer userId) {
        cartRepository.clearCart(userId);
    }

    @Override
    public <S extends Cart> S save(S entity) {
        return cartRepository.save(entity);
    }
}
