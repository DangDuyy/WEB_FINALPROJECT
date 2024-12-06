package com.group8.alomilktea.controller.admin;

import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.entity.Promotion;
import com.group8.alomilktea.service.IProductService;
import com.group8.alomilktea.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/promotion")
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    @Autowired
    private IProductService productService;

    // Show promotion list
    @RequestMapping("/list")
    public String showPromotionList(ModelMap model,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "10") int size) {

        List<Promotion> promotions = promotionService.findAll();
        model.addAttribute("promotions", promotions);

        // Map to store Product names for each promotion
        Map<Integer, String> promotionProductMap = promotions.stream()
                .collect(Collectors.toMap(
                        Promotion::getPromotionId,
                        promotion -> {
                            List<Product> products = promotion.getProducts();
                            return products.stream()
                                    .map(Product::getName)
                                    .collect(Collectors.joining(", "));
                        }));

        model.addAttribute("promotionProductMap", promotionProductMap);

        return "admin/promotions/apps-ecommerce-promotion-list";
    }

    // Add a new promotion
    @GetMapping("/add")
    public String addPromotion(ModelMap model) {
        List<Product> products = productService.findAll(); // Get all products

        model.addAttribute("promotion", new Promotion());
        model.addAttribute("products", products);  // List of products to be chosen
        model.addAttribute("isEdit", false);

        return "admin/promotions/apps-ecommerce-promotion-create";
    }

    // Save new promotion
    @PostMapping("/add/save")
    public String savePromotion(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("discountRate") Integer discountRate,
            @RequestParam(value = "productIds", required = false) List<Integer> productIds,
            ModelMap model) {

        Promotion promotion = new Promotion();
        promotion.setName(name);
        promotion.setDescription(description);
        promotion.setDiscountRate(discountRate);

        // Get the products selected by the user
        if (productIds != null && !productIds.isEmpty()) {
            List<Product> selectedProducts = productService.findByIds(productIds);
            promotion.setProducts(selectedProducts);
        }

        promotionService.save(promotion);
        model.addAttribute("message", "Promotion created successfully!");
        return "redirect:/admin/promotion/list";
    }

    // Edit an existing promotion
    @GetMapping("/edit/{promotionId}")
    public String editPromotion(@PathVariable Integer promotionId, ModelMap model) {
        Promotion promotion = promotionService.findById(promotionId); // Get promotion details
        List<Product> products = productService.findAll(); // Get list of products

        model.addAttribute("promotion", promotion);
        model.addAttribute("products", products);
        model.addAttribute("isEdit", true);

        return "admin/promotions/apps-ecommerce-promotion-create";
    }

    // Save updated promotion
    @PostMapping("/edit/save")
    public String updatePromotion(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("discountRate") Integer discountRate,
            @RequestParam(value = "productIds", required = false) List<Integer> productIds,
            ModelMap model) {

        Promotion promotion = promotionService.findById(id);
        if (promotion == null) {
            model.addAttribute("errorMessage", "Promotion not found!");
            return "redirect:/admin/promotion/list";
        }

        promotion.setName(name);
        promotion.setDescription(description);
        promotion.setDiscountRate(discountRate);

        // Get the products selected by the user
        if (productIds != null && !productIds.isEmpty()) {
            List<Product> selectedProducts = productService.findByIds(productIds);
            promotion.setProducts(selectedProducts);
        }

        promotionService.save(promotion);
        model.addAttribute("message", "Promotion updated successfully!");
        return "redirect:/admin/promotion/list";
    }

    // Delete a promotion
    @PostMapping("/delete/{promotionId}")
    public String deletePromotion(@PathVariable("promotionId") Integer promotionId, ModelMap model) {
        Promotion promotion = promotionService.findById(promotionId);

        if (promotion == null) {
            model.addAttribute("errorMessage", "Promotion not found!");
            return "redirect:/admin/promotion/list";
        }

        promotionService.deleteById(promotionId);
        model.addAttribute("message", "Promotion deleted successfully!");
        return "redirect:/admin/promotion/list";
    }
}
