package com.seqq.springboot_mall.controller;

import com.alibaba.fastjson2.JSON;
import com.seqq.springboot_mall.entity.Admin;
import com.seqq.springboot_mall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller("/AdminLoginController")
public class AdminLoginController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object>  login(String adminName, String adminPassword) {
        Map<String, Object> response = new HashMap<>();

        // 在查询之前将success默认设置为true
        response.put("success", true);

        System.err.println("\u001B[33m" + "adminName:" + adminName + "\u001B[0m");
        System.err.println("\u001B[33m" + "adminPassword:" + adminPassword + "\u001B[0m");

        List<Admin> adminList = adminService.adminLogin(adminName, adminPassword);

        if (adminList.isEmpty()) {
            // 如果查询结果为空，将success设置为false
            response.put("success", false);
            response.put("message", "用户名或密码错误"); // 可以添加一条错误消息
        } else {
            // 查询结果不为空，将查询结果放入响应中
            response.put("data", adminList);
        }

        return response;
    }

    @GetMapping("/goHome")
    public String goLoginPage() {
        return "admin/homePage";
    }


}
