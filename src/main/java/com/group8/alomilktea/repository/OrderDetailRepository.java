package com.group8.alomilktea.repository;

import com.group8.alomilktea.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    @Query("SELECT p.name AS productName, SUM(od.quantity) AS totalQuantity " +
            "FROM OrderDetail od " +
            "JOIN Product p ON p.proId = od.product.proId " +  // Sửa pro_id thành proId
            "GROUP BY p.proId, p.name " +
            "ORDER BY totalQuantity DESC")
    List<Map<String, Object>> findTop5BestSellingProducts();

}
