package com.group8.alomilktea.controller.web;

import com.group8.alomilktea.entity.Cart;
import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.entity.User;
import com.group8.alomilktea.model.ProductDetailDTO;
import com.group8.alomilktea.service.ICartService;
import com.group8.alomilktea.service.IProductService;
import com.group8.alomilktea.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping(value = {"","/","home","trang-chu"})
@Controller
public class HomeController{
    @Autowired
    IProductService productService;
    IUserService userService;
    ICartService cartService;
    @GetMapping()
    public String trangchu(Model model){
        List<ProductDetailDTO> list = productService.findProductInfoBySize();
        model.addAttribute("products", list);
        if (list.isEmpty()) {
            System.out.println("No products found");
        } else {
            System.out.println("Hello anhh em" + list);
        }
        return "web/billy/index";
    }
    @GetMapping("/check-out")
    public String checkout(Model model){
        return "web/billy/checkout";
    }


}
