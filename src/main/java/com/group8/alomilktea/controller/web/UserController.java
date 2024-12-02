package com.group8.alomilktea.controller.web;

import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = {"/user"})
@Controller
public class UserController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public String trangchu(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("products", list);
        System.out.println("Product list: " + list);
        return "web/billy/index";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable("id") Integer id, Model model) {
        Product product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.getCategory());
            System.out.println("Product found: " + product.getCategory());
        } else {
            System.out.println("Product not found with ID: " + id);
            return "web/billy/error-page";
        }
        return "admin/products/product-details";
    }
}
