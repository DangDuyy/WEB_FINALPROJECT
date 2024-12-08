package com.group8.alomilktea.service;

import com.group8.alomilktea.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RevenueService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Long> getMonthlyRevenue() {
        List<Long> revenues = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            revenues.add(orderRepository.getRevenueForMonth(month));
        }
        return revenues;
    }
}