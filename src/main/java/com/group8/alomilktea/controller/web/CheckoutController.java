package com.group8.alomilktea.controller.web;

import com.group8.alomilktea.entity.Cart;
import com.group8.alomilktea.entity.Promotion;
import com.group8.alomilktea.entity.ShipmentCompany;
import com.group8.alomilktea.entity.User;
import com.group8.alomilktea.model.CartModel;
import com.group8.alomilktea.model.ProductDetailDTO;
import com.group8.alomilktea.service.ICartService;
import com.group8.alomilktea.service.IPromotionService;
import com.group8.alomilktea.service.IShipmentCompany;
import com.group8.alomilktea.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("checkout")
public class CheckoutController {
    String PaymentMethod;
    String Note;
    @Autowired(required = true)
    IUserService userService;
    @Autowired(required = true)
    ICartService cartService;
    @Autowired
    IPromotionService promoService;

    @Autowired(required = true)
    IShipmentCompany shipmentCompany;
    @GetMapping("")
    public String ThongtinKh(ModelMap model) {
        double sum = 0;

        User user = userService.getUserLogged();
        String add = user.getAddress();
        String[] parts = add.split("\\s*,\\s*");
        if (parts.length >= 3) {
            model.addAttribute("province", parts[3].trim());
            model.addAttribute("city", parts[2].trim());
            model.addAttribute("commune", parts[1].trim());
            model.addAttribute("address", parts[0].trim());
        } else {
            model.addAttribute("address", add.trim());
        }

        model.addAttribute("user", user);
        List<Cart> cartItems = cartService.findByUserId(user.getUserId());
        List<Double> tong = new ArrayList<>();
        // Tính tổng giá trị của giỏ hàng
        double totalAmount = cartItems.stream()
                .mapToDouble(cart -> cart.getQuantity() * cart.getPrice()) // Giá * Số lượng
                .sum();
        List<Promotion> promotions = promoService.findAll();
        model.addAttribute("promotions", promotions);
        List<ShipmentCompany> express = shipmentCompany.findAll();
        model.addAttribute("shippingMethods", express);
        model.addAttribute("cartItems", cartItems); // Danh sách giỏ hàng
        model.addAttribute("totalAmount", totalAmount); // Tổng giá trị giỏ hàng*/
        return "web/billy/checkout";
    }
}
