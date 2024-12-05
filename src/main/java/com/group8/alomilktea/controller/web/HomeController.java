package com.group8.alomilktea.controller.web;

import com.group8.alomilktea.config.security.AuthUser;
import com.group8.alomilktea.entity.Cart;
import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.entity.User;
import com.group8.alomilktea.model.ProductDetailDTO;
import com.group8.alomilktea.model.UserModel;
import com.group8.alomilktea.service.ICartService;
import com.group8.alomilktea.service.IProductService;
import com.group8.alomilktea.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = {"","/","home","trang-chu"})
@Controller
public class HomeController{
    @Autowired
    IProductService productService;
    @Autowired
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

    @GetMapping("/myaccount")
    public String myAccount(ModelMap model) {
        User userLogged = userService.getUserLogged(); // Get logged-in user details
        if (userLogged != null) {
            String email = userLogged.getEmail();
            Optional<User> optUser = userService.findByEmail(email);
            if (optUser.isPresent()) {
                User user = optUser.get();
                UserModel userModel = new UserModel();
                BeanUtils.copyProperties(user, userModel);
                userModel.setIsEdit(true);

                // Retrieve address and handle possible null or empty values
                String add = userModel.getAddress();
                if (add != null && !add.trim().isEmpty()) {
                    // Split the address into parts
                    String[] parts = add.split("\\s*,\\s*");

                    // Check if there are enough parts
                    if (parts.length >= 3) {
                        model.addAttribute("homeaddress", parts[0].trim());
                        model.addAttribute("town", parts[1].trim());
                        model.addAttribute("district", parts[2].trim());
                        model.addAttribute("city", parts[3].trim()); // Assuming parts[3] exists
                    } else {
                        // If the address format is not as expected, just use the full address
                        model.addAttribute("homeaddress", add.trim());
                    }
                } else {
                    // If the address is null or empty, set homeaddress to a default value or handle it
                    model.addAttribute("homeaddress", "No address provided");
                }

                model.addAttribute("user", userModel);
                return "web/users/my-account";
            }
        }
        return "redirect:/auth/login";
    }

}
