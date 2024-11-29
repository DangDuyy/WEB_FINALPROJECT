package com.group8.alomilktea.service;

import com.group8.alomilktea.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {
    List<Category> findTop10();

    Page<Category> getAll(Integer pageNo);
}
