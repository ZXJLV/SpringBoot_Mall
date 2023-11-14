package com.seqq.springboot_mall.controller;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seqq.springboot_mall.entity.Productorder;
import com.seqq.springboot_mall.entity.Productorderitem;
import com.seqq.springboot_mall.service.ProductorderService;
import com.seqq.springboot_mall.service.ProductorderitemService;
import com.seqq.springboot_mall.util.ColorConsole;
import com.seqq.springboot_mall.util.OrderUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.http.HttpRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Controller
public class ProductorderController {

    @Autowired
    ProductorderService productorderService;

    @Autowired
    ProductorderitemService productorderitemService;

    @GetMapping("/selectProductordersByDate")
    @ResponseBody
    public Map<String, Object> selectProductordersByDate(String beginDate, String endDate, HttpServletRequest request) throws ParseException {
        System.err.println("\u001B[41m" + "selectProductordersByDate" + "\u001B[0m");
        System.err.println("\u001B[41m beginDate:" + beginDate + "\u001B[0m");
        System.err.println("\u001B[41m endDate:" + endDate + "\u001B[0m");

        Map<String, Object> result = new HashMap<>();
//        result.put("dateMap", new String[]{beginDate, endDate});

        String dateFormat = "yyyy-MM-dd";
        List<LocalDate> dateList = OrderUtil.getDateRange(beginDate, endDate, dateFormat);
        String[] dateStringArray = OrderUtil.convertDateListToStringArray(dateList, dateFormat);
        result.put("dateMap", dateStringArray);


        List<Productorder> productorderList = productorderService.selectOrderTotalArray(beginDate, endDate);
        List<Integer> orderTotalList = new ArrayList<>();
        for (Productorder productorder : productorderList) {
            ColorConsole.printCyan("productorder:"+productorder);
            // 假设 productorder 中有一个方法 getTransactionAmount() 返回交易额
            orderTotalList.add(productorder.getDailyTotal());
        }
        // 将 List 转换为 int 数组
        int[] orderTotalArray = orderTotalList.stream().mapToInt(Integer::intValue).toArray();
        for (int i : orderTotalArray) {
            ColorConsole.printPurple("orderTotalArray:"+i);
        }
        result.put("orderTotalArray", orderTotalArray);


        List<Productorder> productorderList1 = productorderService.selectOrderSuccessArray(beginDate, endDate);
        List<Integer> orderSuccesslList = new ArrayList<>();
        for (Productorder productorder : productorderList1) {
            ColorConsole.printCyan("productorder:"+productorder);
            orderSuccesslList.add(productorder.getOrderCount());
        }
        // 将 List 转换为 int 数组
        int[] orderSuccessArray = orderSuccesslList.stream().mapToInt(Integer::intValue).toArray();
        for (int i : orderSuccessArray) {
            ColorConsole.printPurple("orderSuccessArray:"+i);
        }
        result.put("orderSuccessArray", orderSuccessArray);


        List<Productorder> productorderList2 = productorderService.selectOrderUnconfirmedArray(beginDate, endDate);
        List<Integer> orderUnconfirmedList = new ArrayList<>();
        for (Productorder productorder : productorderList2) {
            ColorConsole.printCyan("productorder:"+productorder);
            orderUnconfirmedList.add(productorder.getOrderCount2());
        }
        // 将 List 转换为 int 数组
        int[] orderUnconfirmedArray = orderUnconfirmedList.stream().mapToInt(Integer::intValue).toArray();
        for (int i : orderUnconfirmedArray) {
            ColorConsole.printPurple("orderUnconfirmedArray:"+i);
        }
        result.put("orderUnconfirmedArray", orderUnconfirmedArray);


        List<Productorder> productorderList3 = productorderService.selectOrderNotShippedArray(beginDate, endDate);
        List<Integer> orderNotShippedList = new ArrayList<>();
        for (Productorder productorder : productorderList3) {
            ColorConsole.printCyan("productorder:"+productorder);
            orderNotShippedList.add(productorder.getOrderCount3());
        }
        // 将 List 转换为 int 数组
        int[] orderNotShippedArray = orderNotShippedList.stream().mapToInt(Integer::intValue).toArray();
        for (int i : orderNotShippedArray) {
            ColorConsole.printPurple("orderNotShippedArray:"+i);
        }
        result.put("orderNotShippedArray", orderNotShippedArray);


        result.put("orderUnpaidArray", new int[]{10, 15, 22, 5, 9, 7, 5});
        request.setAttribute("jsonObject", result);
        return result;
    }

}
