package com.seqq.springboot_mall.controller;

import com.alibaba.fastjson2.JSON;
import com.seqq.springboot_mall.entity.Product;
import com.seqq.springboot_mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/foreHomeController")
public class ForeHomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/homeNav")
    @ResponseBody
    public String homeNav(Integer productId) {
        System.err.println("\u001B[36m productId:" + productId + "\u001B[0m");
        List<Product> productList = productService.selectProductAll(productId);
        for (Product product : productList) {
            System.err.println("\u001B[41m homeNav: productList: " + product + "\u001B[0m");
        }
        String json = JSON.toJSONString(productList);
        System.err.println("\u001B[33m json:" + json + "\u001B[0m");
        return json;
    }

}
