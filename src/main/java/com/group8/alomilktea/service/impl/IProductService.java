package com.group8.alomilktea.service.impl;

import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IProductService implements com.group8.alomilktea.service.IProductService {
    ProductRepository productRepository;

    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return productRepository.findOne(example);
    }

    public List<Product> findAll(Sort sort) {
        return productRepository.findAll(sort);
    }

    public Optional<Product> findById(Integer integer) {
        return productRepository.findById(integer);
    }

    public void deleteById(Integer integer) {
        productRepository.deleteById(integer);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {
        productRepository.deleteAllById(integers);
    }

    public long count() {
        return productRepository.count();
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllById(Iterable<Integer> integers) {
        return productRepository.findAllById(integers);
    }

    public <S extends Product> List<S> findAll(Example<S> example) {
        return productRepository.findAll(example);
    }
}
