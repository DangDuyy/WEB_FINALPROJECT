package com.group8.alomilktea.service;

import com.group8.alomilktea.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    Page<Order> getAll(Integer pageNo);

    void updateOrderState(Integer orderId, String newState);
    void deleteById(Integer id);
    List<Order> findOder(Integer userId);
    long count();
    List<Order> findAll();

    Order findById(Integer id);
    Page<Order> findAll(Pageable pageable);

    <S extends Order> S save(S entity);
    int reOnCurrentMonth();

    int reOnCurrentYear();

    int reOnCurrentQuarter();

    float rateCom();
    List<Integer> getMonthlyTotal();
    List<Integer> getQuarterTotal();

    public int countByStatus(String status);

}
