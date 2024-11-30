package com.group8.alomilktea.service;

import com.group8.alomilktea.entity.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    <S extends Product> Optional<S> findOne(Example<S> example);

    List<Product> findAll(Sort sort);

    Optional<Product> findById(Integer integer);

    void deleteById(Integer integer);

    void deleteAllById(Iterable<? extends Integer> integers);

    long count();

    void deleteAll();

    void delete(Product entity);

    List<Product> findAll();

    List<Product> findAllById(Iterable<Integer> integers);

    <S extends Product> List<S> findAll(Example<S> example);
}
