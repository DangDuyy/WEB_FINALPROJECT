package com.group8.alomilktea.controller.admin;

import com.group8.alomilktea.entity.Category;
import com.group8.alomilktea.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    private ICategoryService categoryService;

    @RequestMapping("/list")
    public String list(ModelMap model, @RequestParam(name="pageNo", defaultValue = "0") Integer pageNo) {

        Page<Category> categoryPage = categoryService.getAll(pageNo);

        return "admin/categories/apps-ecommerce-category-list";
    }

}
