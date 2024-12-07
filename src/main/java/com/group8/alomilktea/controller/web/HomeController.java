package com.group8.alomilktea.controller.web;

import com.group8.alomilktea.entity.Cart;
import com.group8.alomilktea.entity.User;
import com.group8.alomilktea.model.ProductDetailDTO;
import com.group8.alomilktea.service.ICartService;
import com.group8.alomilktea.service.IProductService;
import com.group8.alomilktea.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@RequestMapping(value = {"","/","home","trang-chu"})
@Controller
public class HomeController{
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    IProductService productService;
    @Autowired
    IUserService userService;
    @Autowired
    ICartService cartService;
    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        try {
            User userLogged = userService.getUserLogged(); // Lấy thông tin người dùng đã đăng nhập
            List<Cart> cartItems = Collections.emptyList(); // Khởi tạo giỏ hàng rỗng mặc định
            double totalAmount = 0.0; // Giá trị mặc định của tổng giá trị giỏ hàng

            if (userLogged != null) { // Nếu người dùng đã đăng nhập
                cartItems = cartService.findByUserId(userLogged.getUserId()); // Lấy giỏ hàng
                totalAmount = cartItems.stream()
                        .mapToDouble(cart -> cart.getQuantity() * cart.getPrice())
                        .sum(); // Tính tổng giá trị giỏ hàng
            }

            model.addAttribute("cartItems", cartItems); // Đưa giỏ hàng vào model
            model.addAttribute("totalAmount", totalAmount); // Đưa tổng giá trị giỏ hàng vào model

        } catch (Exception e) {
            logger.error("Lỗi khi tải thông tin giỏ hàng: ", e);
            model.addAttribute("cartItems", Collections.emptyList()); // Nếu xảy ra lỗi, giỏ hàng rỗng
            model.addAttribute("totalAmount", 0.0); // Tổng giá trị mặc định là 0
        }
    }

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

    @GetMapping("/user-cart")
    public String viewCart(Model model) {
        try {
            User userLogged = userService.getUserLogged(); // Lấy thông tin người dùng đã đăng nhập

            if (userLogged == null) {
                return "redirect:auth/login"; // Nếu người dùng chưa đăng nhập, chuyển hướng tới trang đăng nhập
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
