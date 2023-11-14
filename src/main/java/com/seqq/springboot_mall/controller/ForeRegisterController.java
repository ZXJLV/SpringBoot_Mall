package com.seqq.springboot_mall.controller;

import com.alibaba.fastjson2.JSON;
import com.google.gson.Gson;
import com.seqq.springboot_mall.entity.Address;
import com.seqq.springboot_mall.mapper.AddressMapper;
import com.seqq.springboot_mall.service.AddressService;
import com.seqq.springboot_mall.service.UserService;
import com.seqq.springboot_mall.util.AddressData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ForeRegisterController {

    @Autowired
    AddressService addressService;

    @Autowired
    UserService userService;

    @GetMapping("/toRegister")
    public  String toRegister(HttpServletRequest request) {
        List<Address> addressList = addressService.selectAddress();
        for (Address address : addressList) {
            System.err.println("\u001B[41maddressList:" + address + "\u001B[0m");
        }

        request.setAttribute("addressList", addressList);
        return "/fore/register";
    }

    @GetMapping("/address")
    @ResponseBody
    public Object address(HttpServletRequest request , int addressAreaId) {
        System.err.println("\u001B[33maddressAreaId:" + addressAreaId + "\u001B[0m");

        List<Address> cityList = addressService.selectAddressByAddressRegionId(addressAreaId);
        for (Address address : cityList) {
            System.err.println("\u001B[41ma cityList:" + address + "\u001B[0m");
        }

        Address firstAddress = cityList.get(0); // 获取第一个元素
        int firstAddressAreaId = Integer.parseInt(firstAddress.getAddressAreaId());
        // 现在 firstAddressAreaId 包含了第一组数据的 addressAreaId
        System.out.println("第一组数据的 addressAreaId: " + firstAddressAreaId);

        List<Address> districtList = addressService.selectAddressByAddressRegionId(firstAddressAreaId);
        for (Address address : districtList) {
            System.err.println("\u001B[41ma cityList:" + address + "\u001B[0m");
        }

        request.setAttribute("cityList", cityList);
        request.setAttribute("districtList", districtList);

        // 创建 AddressData 对象并设置数据
        AddressData addressData = new AddressData(cityList, districtList);
        String jsonResponse = new Gson().toJson(addressData);

        System.err.println("\u001B[33m cityListJson:" + jsonResponse + "\u001B[0m");
        return jsonResponse;
    }


    @PostMapping("/doRegister")
    @ResponseBody
    public String doRegister(String userName, String userPassword, String userNickName, String userBirthday, int userGender, int userAddress) {
        System.err.println("\u001B[33m" + "doRegister" + "\u001B[0m");
        int insertUser = userService.insertUser(userName, userPassword, userNickName, userBirthday, userGender, userAddress);
        String json = new Gson().toJson(insertUser);

        System.err.println("\u001B[33m json:" + json + "\u001B[0m");
        return json;
    }

}
