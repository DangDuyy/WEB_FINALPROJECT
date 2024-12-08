package com.group8.alomilktea.controller.manager;

import com.group8.alomilktea.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/revenue")
public class RevenueController {

    @Autowired
    private RevenueService revenueService;

    @GetMapping
    public List<Long> getMonthlyRevenue() {
        return revenueService.getMonthlyRevenue();
    }
}