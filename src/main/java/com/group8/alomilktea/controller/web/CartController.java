package com.group8.alomilktea.controller.web;

import com.group8.alomilktea.entity.Cart;
import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.entity.ProductDetail;
import com.group8.alomilktea.entity.User;
import com.group8.alomilktea.model.CartModel;
import com.group8.alomilktea.model.ProductDetailDTO;
import com.group8.alomilktea.service.ICartService;
import com.group8.alomilktea.service.IProductService;
import com.group8.alomilktea.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@RequestMapping("/cart")
@Controller
public class CartController {
    @Autowired(required=true)
    IUserService userService;
    @Autowired(required=true)
    ICartService cartService;
    @Autowired(required=true)
    IProductService productService;
    @Autowired(required = true)
    IProductService proService;


}





