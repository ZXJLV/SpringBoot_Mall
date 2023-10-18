package com.seqq.springboot_mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/AdminController")
public class AdminController {

    @GetMapping("/")
    public String goLoginPage() {
        return "admin/loginPage";
    }

}
