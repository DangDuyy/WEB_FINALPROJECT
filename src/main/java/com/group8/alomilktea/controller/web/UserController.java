package com.group8.alomilktea.controller.web;

import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.model.ProductDetailDTO;
import com.group8.alomilktea.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = {"web/product"})  // Cố định id = 1
@Controller
public class UserController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public String trangchu(Model model) {
        String currentUserName = "1";  // Giả lập người dùng có id = 1

        // Lấy danh sách sản phẩm
        List<ProductDetailDTO> list = productService.findProductInfoBySize();
        model.addAttribute("products", list);
        model.addAttribute("userId", currentUserName);  // Thêm userId vào model

        System.out.println("Product list: " + list);
        return "web/billy/index";
    }

    @GetMapping("detail/{id}")
    public String product(@PathVariable("id") Integer id, Model model) {
        String currentUserName = "1";  // Giả lập người dùng có id = 1
        List<ProductDetailDTO> product = productService.findProductInfoByID(id);
        model.addAttribute("prd", product);  // Sửa lại là "prd" thay vì "product"
        model.addAttribute("userId", currentUserName);  // Thêm userId vào model
        System.out.println("Product found: " + product);
        return "web/billy/product-details";
    }
}
