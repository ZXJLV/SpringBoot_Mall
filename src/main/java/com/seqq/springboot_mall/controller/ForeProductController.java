package com.seqq.springboot_mall.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seqq.springboot_mall.entity.*;
import com.seqq.springboot_mall.service.*;
import com.seqq.springboot_mall.util.ColorConsole;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Random;

import java.util.List;

@Controller("/ForeProductController")
public class ForeProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductorderService productorderService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductimageService productimageService;

    @Autowired
    ProductorderitemService productorderitemService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @GetMapping("/product/{productId}")
    public String product(@PathVariable int productId, HttpServletRequest request) {
        System.err.println("\u001B[33m productId:" + productId + "\u001B[0m");
        Product product = productService.selectProductByProductorderitemProductId(productId);
        Category category = categoryService.selectCategoryByProductCategoryId(product.getProductCategoryId());
        product.setCategory(category);
        List<Productimage> productimageList = productimageService.selectProductimageAll(product.getProductId());
        product.setSingleProductImageList(productimageList);
        int productSaleCount = productorderitemService.selectProductorderitemNumberSumBypProductId(product.getProductId());
        product.setProductSaleCount(productSaleCount);
        List<Review> reviewList = reviewService.selectReviewByProductId(product.getProductId());
        product.setReviewList(reviewList);
        for (Review review : reviewList) {
            product.setProductReviewCount(review.getReviewContent());
            User user = userService.selectUserByUserId(review.getReviewUserId());
            review.setReviewUser(user);
        }

        List<Product> productList = productService.selectProductAll2(product.getProductId());
        for (Product product1 : productList) {
            List<Productimage> productimageList2 = productimageService.selectProductimageAll(product1.getProductId());
            product1.setSingleProductImageList(productimageList2);
        }

        List<Category> categoryList = categoryService.selectCategoryAll();

        List<Productimage> productimageList1 = productimageService.selectProductimageAll2(product.getProductId());
        product.setDetailProductImageList(productimageList1);

        request.setAttribute("product", product);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("loveProductList", productList);
        return "/fore/productDetailsPage";
    }

    @GetMapping("/cart/{userId}")
    public String cart(HttpServletRequest request, @PathVariable int userId) {
        List<Product> productList = productService.selectProductByProductId();

        Random random = new Random();
        int randomIndex = random.nextInt(productList.size());
        Product randomProduct = productList.get(randomIndex);
        request.setAttribute("searchValue", randomProduct.getProductName());

        List<Category> categoryList = categoryService.selectCategoryAll();
        List<Productorder> productorderList = productorderService.selectProductorderByProductorderPayDateIsNullAndUserId(userId);
        for (Productorder productorder : productorderList) {
            List<Productorderitem> productorderitemList = productorderitemService.selectProductorderitemByProductorderitemOrderId(productorder.getProductorderId());
            for (Productorderitem productorderitem : productorderitemList) {
                Product product = productService.selectProductByProductorderitemProductId(productorderitem.getProductOrderItemProductId());
                Category category = categoryService.selectCategoryByProductCategoryId(product.getProductCategoryId());
                product.setCategory(category);
                List<Productimage> productimageList = productimageService.selectProductimageAll(product.getProductId());
                product.setSingleProductImageList(productimageList);
                productorderitem.setProduct(product);
            }
            request.setAttribute("orderItemList", productorderitemList);
        }

        request.setAttribute("orderItemTotal", productorderList.size());

        request.setAttribute("categoryList", categoryList);
        return "fore/productBuyCarPage";
    }

    @PutMapping("/orderItem")
    @ResponseBody
    public String orderItem(String orderItemMap) {
        ColorConsole.printRed("orderItem");
        ColorConsole.printRed("orderItemMap:"+orderItemMap);

        String key = orderItemMap.substring(2, 5);
        int productOrderItemId = Integer.parseInt(key);
        ColorConsole.printPurple("productOrderItemId:"+productOrderItemId);
        Productorderitem productorderitem = productorderitemService.selectProductorderitemsByProductorderitemId(productOrderItemId);
        ColorConsole.printGreen("productorderitem:"+productorderitem);
        Productorder productorder = productorderService.selectProductorderByProductorderId(productorderitem.getProductOrderItemOrderId());
        ColorConsole.printGreen("productorder:"+productorder);

        return productorder.getProductOrderCode();
    }

    @GetMapping("/byCart/{userId}/{productOrderCode}")
    public String byCart(@PathVariable int userId, @PathVariable String productOrderCode) {
        ColorConsole.printWhite("byCart");
        ColorConsole.printPurple("productOrderCode"+productOrderCode);
        ColorConsole.printPurple("userId"+userId);

        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();

        // 格式化输出
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        int i = productorderService.updateProductorderProductorderStatusAndProductorderPayDateByProductorderId(productOrderCode, formattedTime);
        return "redirect:/order/" + userId;
    }

}
