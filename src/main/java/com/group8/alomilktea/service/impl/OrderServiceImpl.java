package com.group8.alomilktea.service.impl;

import com.group8.alomilktea.entity.Order;
import com.group8.alomilktea.repository.OrderRepository;
import com.group8.alomilktea.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public Page<Order> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 10);
        return orderRepository.findAllCustom(pageable);
    }

    @Override
    public void updateOrderState(Integer orderId, int newState) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(newState);
            orderRepository.save(order);
        } else {}
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }
}
