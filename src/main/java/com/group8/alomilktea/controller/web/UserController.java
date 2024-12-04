package com.group8.alomilktea.controller.web;

import com.group8.alomilktea.common.enums.ProductAttribute;
import com.group8.alomilktea.entity.*;
import com.group8.alomilktea.model.ProductDetailDTO;
import com.group8.alomilktea.service.ICartService;
import com.group8.alomilktea.service.IProductService;
import com.group8.alomilktea.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping(value = {"web/product"})  // Cố định id = 1
@Controller
public class UserController {

    @Autowired
    private IProductService productService;

    @Autowired(required=true)
    ICartService cartService;

    @Autowired(required=true)
    IUserService userService;

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
    // Controller xử lý yêu cầu AJAX để lấy giá sản phẩm theo size
    @RequestMapping("/getPrice")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getPrice(@RequestParam Long productId, @RequestParam String size) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Sử dụng phương thức trả về đối tượng duy nhất
            ProductDetailDTO product = productService.findProductInfoByIDAndSize(productId, size);

            if (product != null) {
                response.put("success", true);
                response.put("price", product.getPrice());
            } else {
                response.put("success", false);
                response.put("message", "Không tìm thấy sản phẩm với kích thước này.");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Lỗi khi lấy giá sản phẩm.");
        }
        return ResponseEntity.ok(response);
    }




    @GetMapping("/addToCart")
    public ResponseEntity<String> addToCart(
            @RequestParam("productId") Integer proId,
            @RequestParam("qty") Integer qty,
            @RequestParam("size") String size,
            @RequestParam("price") Double price) {

        try {
            String successMessage = "Thêm vào giỏ hàng thành công";

            // Tìm sản phẩm trong cơ sở dữ liệu
            Optional<Product> optProduct = productService.findById0p(proId);
            if (optProduct.isEmpty()) {
                return new ResponseEntity<>("Sản phẩm không tồn tại", HttpStatus.NOT_FOUND);
            }

            Product product = optProduct.get();
            User userLogged = userService.getUserLogged();

            // Lấy danh sách giỏ hàng của người dùng
            List<Cart> cartList = cartService.findByUserId(userLogged.getUserId());

            // Tìm sản phẩm trong giỏ hàng với cùng proId và size
            Optional<Cart> existingCartItem = cartList.stream()
                    .filter(cart -> cart.getProduct().getProId().equals(proId) && cart.getId().getSize().equals(size))
                    .findFirst();

            if (existingCartItem.isPresent()) {
                // Nếu sản phẩm cùng proId và size đã tồn tại, cộng dồn số lượng
                Cart cart = existingCartItem.get();
                int updatedQuantity = cart.getQuantity() + qty;

                // Kiểm tra tồn kho nếu cần


                // Cập nhật số lượng trong giỏ hàng
                cart.setQuantity(updatedQuantity);
                cartService.save(cart);

                return new ResponseEntity<>(successMessage, HttpStatus.OK);
            } else {
                // Nếu sản phẩm khác size hoặc không tồn tại trong giỏ hàng, thêm mục mới
                CartKey cartKey = new CartKey(userLogged.getUserId(), proId, size);  // Sử dụng proId và size làm khóa hợp nhất
                Cart newCart = new Cart();
                newCart.setId(cartKey);
                newCart.setProduct(product);
                newCart.setUser(userLogged);
                newCart.getId().setSize(size);
                newCart.setQuantity(qty);
                newCart.setPrice(price);

                // Kiểm tra tồn kho


                // Lưu giỏ hàng mới
                cartService.save(newCart);

                return new ResponseEntity<>(successMessage, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Lỗi khi thêm sản phẩm vào giỏ hàng: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}










