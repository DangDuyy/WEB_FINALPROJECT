package com.group8.alomilktea.controller.web;

import com.group8.alomilktea.entity.Category;
import com.group8.alomilktea.model.ProductDetailDTO;
import com.group8.alomilktea.service.ICategoryService;
import com.group8.alomilktea.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = {"web/category"})  // Cố định id = 1
@Controller("webCategoryController")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IProductService productService ;

    @GetMapping("{id}")
    public String showCategories(@PathVariable("id") Integer id, ModelMap model) {
        List<ProductDetailDTO> list = productService.findProductInfoByCatID(id);
        String namec = categoryService.findNameById(id);
        List<Category> listcat = categoryService.findAll();
        model.addAttribute("products", list);
        model.addAttribute("categories", listcat);
        model.addAttribute("name", namec);
        return "web/billy/category"; // Tên file HTML
    }
}
