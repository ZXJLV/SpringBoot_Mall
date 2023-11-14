package com.seqq.springboot_mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/LoginController")
public class LoginController {

    @GetMapping("/")
    public String goLoginPage() {
        return "admin/loginPage";
//        return "fore/loginPage";
    }

}
