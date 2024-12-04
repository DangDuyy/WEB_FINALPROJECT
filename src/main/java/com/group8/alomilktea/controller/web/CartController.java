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

@RequestMapping("/tatduy")
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
    @GetMapping()
    public String viewCart(Model model) {
        try {
            User userLogged = userService.getUserLogged(); // Lấy thông tin người dùng đã đăng nhập

            if (userLogged == null) {
                return "redirect:/login"; // Nếu người dùng chưa đăng nhập, chuyển hướng tới trang đăng nhập
            }

            // Lấy danh sách sản phẩm trong giỏ hàng của người dùng
            List<Cart> cartItems = cartService.findByUserId(userLogged.getUserId());

            // Tính tổng giá trị của giỏ hàng
            double totalAmount = cartItems.stream()
                    .mapToDouble(cart -> cart.getQuantity() * cart.getPrice()) // Giá * Số lượng
                    .sum();

            // Đưa danh sách sản phẩm và tổng giá trị vào model
            model.addAttribute("cartItems", cartItems); // Danh sách giỏ hàng
            model.addAttribute("totalAmount", totalAmount); // Tổng giá trị giỏ hàng

            return "web/billy/cart-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Không thể tải giỏ hàng. Vui lòng thử lại sau.");
            return "error"; // Trả về trang lỗi
        }
    }

}





