package com.group8.alomilktea.service.impl;

import com.group8.alomilktea.entity.Category;
import com.group8.alomilktea.repository.CategoryRepository;
import com.group8.alomilktea.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository repo;

    @Override
    public List<Category> findTop10() {
        return repo.findAll(PageRequest.of(0, 10)).getContent();
    }

    @Override
    public Page<Category> getAll(Integer pageNo) {
        int pageSize = 10;
        return repo.findAll(PageRequest.of(pageNo, pageSize));
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Category> findAllById(Iterable<Integer> id) {
        return repo.findAllById(id);
    }

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public <S extends Category> S save(S entity) {
        return repo.save(entity);
    }
}
