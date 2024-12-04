package com.group8.alomilktea.service.impl;

import com.group8.alomilktea.entity.Promotion;
import com.group8.alomilktea.repository.PromotionRepository;
import com.group8.alomilktea.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements IPromotionService {
    @Autowired
    private PromotionRepository repo;
    @Override
    public List<Promotion> findAll() {
        return repo.findAll();
    }

    @Override
    public Promotion findById(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
