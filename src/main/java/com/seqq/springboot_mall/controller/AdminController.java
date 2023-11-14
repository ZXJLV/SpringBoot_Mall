package com.seqq.springboot_mall.controller;

import com.seqq.springboot_mall.util.ColorConsole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/AdminController")
public class AdminController {

    @GetMapping("/admin/{url}")
    @ResponseBody
    public String admin(@PathVariable String url) {
        ColorConsole.printWhite("url: " + url);

        if (url.equals("product")) {
            return "<%@include file='productManagePage.jsp'%>";
        }

        return "";
    }

}
