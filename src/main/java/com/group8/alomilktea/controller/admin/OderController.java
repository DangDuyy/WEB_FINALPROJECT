package com.group8.alomilktea.controller.admin;

import com.group8.alomilktea.entity.Order;
import com.group8.alomilktea.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("admin/orders")
public class OderController {
    @Autowired(required = true)
    IOrderService orderSer;
    @RequestMapping("")
    public String listOrders(
            ModelMap model,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        Page<Order> page = orderSer.getAll(pageNo);
        long totalOrders = orderSer.count();
        model.addAttribute("orders", page.getContent());
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalOrders", totalOrders);
        return "admin/orders/list.html";
    }


    @GetMapping("updateState/{orderId}/{newState}")
    public String updateOrderState(@PathVariable("orderId") Integer orderId, @PathVariable("newState") String newState) {
        orderSer.updateOrderState(orderId, newState);
        return "redirect:/admin/orders";
    }


    @GetMapping("delete/{orderId}")
    public ModelAndView deleteOder(ModelMap model, @PathVariable("orderId") Integer orderId) {
        try {
            orderSer.deleteById(orderId);
            model.addAttribute("message", "Order is deleted!!!!");
        } catch (Exception e) {
            model.addAttribute("message", "Cannot delete!!!!");
        }
        return new ModelAndView("forward:/admin/orders", model);
    }
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable Integer userId) {
        return orderSer.findOder(userId);
    }
    @GetMapping("/search")
    public String searchOrder(@RequestParam("search") String search, Model model) {
        try {
            Integer userId = Integer.parseInt(search); // Nếu tìm kiếm bằng UserId
            List<Order> orders = orderSer.findOder(userId);
            model.addAttribute("orders", orders);
        } catch (NumberFormatException e) {
            model.addAttribute("message", "Invalid UserId. Please enter a valid number.");
            model.addAttribute("orders", List.of()); // Trả về danh sách rỗng
        }

        return "admin/orders/list"; // Tên file Thymeleaf hiển thị kết quả
    }


}
