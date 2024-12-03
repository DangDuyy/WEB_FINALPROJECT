package com.group8.alomilktea.service;

import com.group8.alomilktea.entity.Cart;
import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.entity.ProductDetail;
import com.group8.alomilktea.model.ProductDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductService {

    Product save(Product product);

    Product findById(Integer id);

    void deleteById(Integer id);

    Page<Product> getAll(Pageable pageable);

    List<Product> findAll();
    String getCategoryNameByProductId(Integer productId);

    String getPromotionNameByProductId(Integer productId);

    List<ProductDetail> findProductDetailsByProductId(Integer productId);
    List<ProductDetailDTO> findProductInfoByID(Integer productId);
    List<ProductDetailDTO> findProductInfoBySize();


}