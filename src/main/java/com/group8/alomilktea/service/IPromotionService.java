package com.group8.alomilktea.service;

import com.group8.alomilktea.entity.Promotion;

import java.util.List;

public interface IPromotionService {

    List<Promotion> findAll();

    Promotion findById(Integer id);
}
