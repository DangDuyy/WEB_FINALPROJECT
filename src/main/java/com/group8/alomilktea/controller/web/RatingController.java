package com.group8.alomilktea.controller.web;

import com.group8.alomilktea.entity.Product;
import com.group8.alomilktea.entity.Rating;
import com.group8.alomilktea.entity.User;
import com.group8.alomilktea.service.ICartService;
import com.group8.alomilktea.service.IProductService;
import com.group8.alomilktea.service.IRatingService;
import com.group8.alomilktea.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/ratings")
@RestController
public class RatingController {

    @Autowired
    IRatingService ratingService;
    @Autowired
    IUserService userService;
    @Autowired
    IProductService productService ;
//    @GetMapping("/product/{productId}")
//    public List<Rating> getRatingsByProduct(@PathVariable Integer productId) {
//        return ratingService.getRatingsByProductId(productId);
//    }
//
//    // Thêm đánh giá mới
//    @PostMapping("/add")
//    public Rating addRating(@RequestBody Rating rating) {
//        User userLogged = userService.getUserLogged();
//        rating.getUser().setUserId(userLogged.getUserId());
//        return ratingService.addRating(rating);
//    }


//    @GetMapping("/product/{productId}")
//    public List<Rating> getRatingsByProduct(@PathVariable Integer productId) {
//        System.out.println("Fetching ratings for product ID: " + productId); // Log productId
//        List<Rating> ratings = ratingService.getRatingsByProductId(productId);
//        System.out.println("Ratings retrieved: " + ratings); // Log danh sách đánh giá
//        return ratings;
//    }


    @GetMapping("/product/{productId}")
    public List<Rating> getRatingsByProduct(@PathVariable Integer productId) {
        // Log sản phẩm được truy vấn
        System.out.println("Fetching ratings for product ID: " + productId); // Log productId
        List<Rating> ratings = ratingService.getRatingsByProductId(productId);

        // Kiểm tra xem danh sách đánh giá đã lấy có dữ liệu hay không
        if (ratings != null && !ratings.isEmpty()) {
            System.out.println("Ratings retrieved: ");
            for (Rating rating : ratings) {
                System.out.println("Rating ID: " + rating.getUser().getUserId() + ", Rate: " + rating.getRate() + ", Content: " + rating.getContent());
            }
        } else {
            System.out.println("No ratings found for product ID: " + productId);
        }

        // Trả về danh sách đánh giá
        return ratings;
    }

    @PostMapping("/add")
    public Rating addRating(
            @RequestParam Integer productId,
            @RequestParam String content,
            @RequestParam Integer rate,
            @RequestParam String platform,
            @RequestParam String date
    ) {
        Rating rating = new Rating();
        User userLogged = userService.getUserLogged();
        rating.setUser(userLogged);
        Product product = productService.findById(productId);
        rating.setProduct(product);
        rating.setContent(content);
        rating.setRate(rate);
        rating.setPlatform(platform);
        rating.setDate(date);
        Rating newRating = ratingService.addRating(rating); // Lưu đánh giá vào database
        System.out.println("Rating added: " + newRating); // Log thông tin đánh giá mới đã được thêm
        return newRating; // Trả về đánh giá mới
    }
}
