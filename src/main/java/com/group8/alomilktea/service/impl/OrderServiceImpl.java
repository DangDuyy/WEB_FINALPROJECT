package com.group8.alomilktea.service.impl;

import com.group8.alomilktea.entity.Order;
import com.group8.alomilktea.repository.OrderRepository;
import com.group8.alomilktea.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void updateOrderState(Integer orderId, String newState) {
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

    @Override
    public List<Order> findOder(Integer userId) {
        return orderRepository.findOrderByUserId(userId);
    }

    @Override
    public long count() {
        return orderRepository.count();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public <S extends Order> S save(S entity) {
        return orderRepository.save(entity);
    }

    @Override
    public int reOnCurrentMonth() {
        return orderRepository.revenueOnCurrentMonth();
    }

    @Override
    public int reOnCurrentYear() {
        return orderRepository.revenueOnCurrentYear();
    }

    @Override
    public int reOnCurrentQuarter() {
        return orderRepository.revenueOnCurrentQuarter();
    }

    @Override
    public float rateCom() {
        return orderRepository.rateCompleted();
    }

    @Override
    public List<Integer> getMonthlyTotal() {
        return orderRepository.getMonthlyTotal();
    }

    @Override
    public List<Integer> getQuarterTotal() {
        return orderRepository.getQuarterTotal();
    }

    @Override
    public int countByStatus(String status) {
        return orderRepository.countByStatus(status);
    }
}
