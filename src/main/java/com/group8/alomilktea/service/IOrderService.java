package com.group8.alomilktea.service;

import com.group8.alomilktea.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrderService {
    Page<Order> getAll(Integer pageNo);

    void updateOrderState(Integer orderId, int newState);
    void deleteById(Integer id);
}
