package com.seqq.springboot_mall.controller;

import com.seqq.springboot_mall.entity.Product;
import com.seqq.springboot_mall.entity.Productimage;
import com.seqq.springboot_mall.entity.Productorderitem;
import com.seqq.springboot_mall.entity.Review;
import com.seqq.springboot_mall.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller("/ForeReviewController")
public class ForeReviewController {

    @Autowired
    ProductorderitemService productorderitemService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductimageService productimageService;

    @GetMapping("/review/{productOrderItemId}")
    public String review(@PathVariable("productOrderItemId") int productOrderItemId, HttpServletRequest request) {
        System.err.println("\u001B[33m productOrderItemId:" + productOrderItemId + "\u001B[0m");
        Productorderitem productorderitem = productorderitemService.selectProductorderitemsByProductorderitemId(productOrderItemId);

        Product product = productService.selectProductByProductorderitemProductId(productorderitem.getProductOrderItemProductId());

        List<Productimage> productimageList = productimageService.selectProductimageAll(product.getProductId());
        product.setSingleProductImageList(productimageList);

        request.setAttribute("productorderitem", productorderitem);
        request.setAttribute("product", product);
        return "fore/orderSuccessPage";
    }

    @GetMapping("/getReview/{productOrderItemId}")
    public String getReview(@PathVariable("productOrderItemId") int productOrderItemId, HttpServletRequest request) {
        System.err.println("\u001B[33m productOrderItemId:" + productOrderItemId + "\u001B[0m");
        Productorderitem productorderitem = productorderitemService.selectProductorderitemsByProductorderitemId(productOrderItemId);

        List<Product> productList = productService.selectProductAndReviewByProductId(productorderitem.getProductOrderItemProductId());

        for (Product product : productList) {
            List<Productimage> productimageList = productimageService.selectProductimageAll(product.getProductId());
            product.setSingleProductImageList(productimageList);

            productorderitem.setProduct(product);
        }
        System.err.println("\u001B[41m productorderitem:" + productorderitem + "\u001B[0m");
        request.setAttribute("productorderitem", productorderitem);
        return "fore/addReview";
    }

    @PostMapping("/addReview")
    @ResponseBody
    public String addReview(String reviewContent, int productOrderItemId, int reviewUserId, int reviewProductId) {
        System.out.println("addReview");

        System.err.println("\u001B[41m reviewContent:" + reviewContent + "\u001B[0m");
        System.err.println("\u001B[41m productOrderItemId:" + productOrderItemId + "\u001B[0m");
        System.err.println("\u001B[41m reviewUserId:" + reviewUserId + "\u001B[0m");
        System.err.println("\u001B[41m reviewProductId:" + reviewProductId + "\u001B[0m");

        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String reviewCreatedate = currentDateTime.format(formatter);

        int i = reviewService.insertReview(new Review(-1, reviewContent, reviewCreatedate, reviewUserId, reviewProductId, productOrderItemId, null));

        return "/fore/homePage";
    }

}
