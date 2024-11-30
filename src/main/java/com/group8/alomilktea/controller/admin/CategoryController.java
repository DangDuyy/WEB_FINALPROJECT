package com.group8.alomilktea.controller.admin;

import com.group8.alomilktea.entity.Category;
import com.group8.alomilktea.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/list")
    public String showCategoryList(ModelMap model, @RequestParam(name="pageNo", defaultValue = "0") Integer pageNo) {

        Page<Category> categoryPage = categoryService.getAll(pageNo);

        model.addAttribute("categories", categoryPage);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", categoryPage.getTotalPages());


        return "admin/categories/apps-ecommerce-category-list";
    }

    @GetMapping("/add")
    public String addCategory(ModelMap model){
        return "admin/categories/apps-ecommerce-category-create";
    }

    @PostMapping("/add/save")
    public String saveCategory(
            @RequestParam("name") String name,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            @RequestParam(value = "imageUrl", required = false) String imageUrl,
            @RequestParam(value = "description", required = false) String description,
            ModelMap model) {

        Category category = new Category();
        category.setName(name);
        category.setDescription(description);

        // Option 1: Nếu người dùng tải file
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
                category.setLogo("/uploads/" + fileName); // Lưu đường dẫn
                imageFile.transferTo(new File("uploads/" + fileName)); // Lưu file vào thư mục
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Option 2: Nếu người dùng nhập URL
        else if (imageUrl != null && !imageUrl.trim().isEmpty()) {
            category.setLogo(imageUrl);
        }

        categoryService.save(category);
        model.addAttribute("message", "Category created successfully!");
        return "redirect:/admin/category/list";
    }




}
