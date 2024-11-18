package com.group8.alomilktea.controller.web;

import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = {"","/","home","trang-chu"})
@Controller
public class HomeController{
    @Autowired
    IProductService productService;
    @GetMapping()
    public String trangchu(Model model){
        List<Product> list = productService.findAll();
        model.addAttribute("products", list);
        if (list.isEmpty()) {
            System.out.println("No products found");
        } else {
            System.out.println("Hello anhh em" + list);
        }

        return "web/billy/index";
    }
}
