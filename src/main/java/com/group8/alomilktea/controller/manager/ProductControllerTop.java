package com.group8.alomilktea.controller.manager;

import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.repository.BestSellingProductDTO;
import com.group8.alomilktea.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController

public class ProductControllerTop {
    @Autowired
    private ProductService productService;

    @GetMapping("/api/top-selling-products")
    public List<Product> getTopSellingProducts() {
        return productService.getTop5BestSellingProducts();
    }
}
