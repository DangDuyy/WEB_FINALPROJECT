package com.group8.alomilktea.repository;

import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p.category.name FROM Product p WHERE p.proId = :productId")
    String findCategoryNameByProductId(@Param("productId") Integer productId);

    @Query("SELECT p.promotion.name FROM Product p WHERE p.proId = :productId")
    String findPromotionNameByProductId(@Param("productId") Integer productId);

    @Query("SELECT pd FROM ProductDetail pd WHERE pd.product.proId = :productId")
    List<ProductDetail> findProductDetailsByProductId(@Param("productId") Integer productId);
}
