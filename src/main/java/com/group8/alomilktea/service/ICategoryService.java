package com.group8.alomilktea.service;

import com.group8.alomilktea.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findTop10();

    Page<Category> getAll(Integer pageNo);

    void deleteById(Integer id);

    long count();

    Optional<Category> findById(Integer id);

    List<Category> findAllById(Iterable<Integer> id);

    List<Category> findAll();

    <S extends Category> S save(S entity);
}
