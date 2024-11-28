package com.group8.alomilktea.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CategoryController {

    @RequestMapping("/admin/category/list")
    public String showListCategories(){
        return "admin/categories/apps-ecommerce-category-list";
    }

}
