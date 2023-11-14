package com.seqq.springboot_mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForeSkipController {

//    @RequestMapping("/toHomePage")
//    public String toHomePage() {
//        return "/fore/homePage";
//    }

    @GetMapping("/foreQuit")
    public String quit() {
        return "/fore/loginPage";
    }

    @GetMapping("/toUserDetails")
    public String toUserDetails() {
        return "/fore/userDetails";
    }

//    @GetMapping("/toRegister")
//    public String toRegister() {
//        return "/fore/register";
//    }



}
