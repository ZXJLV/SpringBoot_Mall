package com.seqq.springboot_mall.service;

import com.seqq.springboot_mall.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {

    List<Admin> adminLogin(String adminName, String adminPassword);

}
