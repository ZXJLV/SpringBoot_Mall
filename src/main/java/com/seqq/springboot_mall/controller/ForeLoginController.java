package com.seqq.springboot_mall.controller;

import com.alibaba.fastjson2.JSON;
import com.seqq.springboot_mall.entity.Category;
import com.seqq.springboot_mall.entity.Product;
import com.seqq.springboot_mall.entity.Productimage;
import com.seqq.springboot_mall.entity.User;
import com.seqq.springboot_mall.mapper.CategoryMapper;
import com.seqq.springboot_mall.service.CategoryService;
import com.seqq.springboot_mall.service.ProductService;
import com.seqq.springboot_mall.service.ProductimageService;
import com.seqq.springboot_mall.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/ForeLoginController")
public class ForeLoginController {

    @Autowired
    UserService userService;

    @PostMapping("/foreLogin")
    @ResponseBody
    public Map<String, Object> foreLogin(String userName, String userPassword, HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        // 在查询之前将success默认设置为true
        response.put("success", true);

        System.err.println("\u001B[33m" + userName + "\u001B[0m");
        System.err.println("\u001B[33m" + userPassword + "\u001B[0m");

        User user = userService.userLogin(userName, userPassword);
        System.err.println("\u001B[41m" + user + "\u001B[0m");
        if (user == null) {
            // 如果查询结果为空，将success设置为false
            response.put("success", false);
        } else {
            session.setAttribute("user", user);
            // 查询结果不为空，将查询结果放入响应中
            response.put("data", user);
        }

        return response;
    }

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductimageService productimageService;

    @GetMapping("/toHomePage")
    public String toHomePage(HttpServletRequest request) {
        System.err.println("\u001B[41m" + "toHomePage" + "\u001B[0m");
        List<Product> specialProductList = productService.selectProductByProductId();
        for (Product product : specialProductList) {
            System.err.println("\u001B[41m productList:" + product + "\u001B[0m");
        }

        List<Category> categoryList = categoryService.selectCategoryAll();
        for (Category category2 : categoryList) {
            List<Product> productList = productService.selectProductAll(category2.getCategoryId());
            for (Product product : productList) {
                List<Productimage> singleProductImageList = productimageService.selectProductimageAll(product.getProductId());
                for (Productimage productimage : singleProductImageList) {
                    System.err.println("\u001B[33m productimage:" + productimage + "\u001B[0m");
                }
                product.setSingleProductImageList(singleProductImageList);
                System.err.println("\u001B[41m productList:" + product + "\u001B[0m");
            }
            category2.setProductList(productList);
            System.err.println("\u001B[36m categoryList:" + category2 + "\u001B[0m");
        }

        request.setAttribute("categoryList", categoryList);
        request.setAttribute("specialProductList", specialProductList);

        return "/fore/homePage";
    }


}
