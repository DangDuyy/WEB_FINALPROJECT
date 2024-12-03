package com.group8.alomilktea.model;

import com.group8.alomilktea.common.enums.ProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDTO { // Sử dụng "class" thay vì định nghĩa constructor
    private Integer proId;
    private String name;
    private String description;
    private String imageLink;
    private Integer cateId;
    private Integer proDId;
    private ProductAttribute size; // Enum
    private Double price;
}
