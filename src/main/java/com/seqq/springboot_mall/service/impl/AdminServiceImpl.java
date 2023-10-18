package com.seqq.springboot_mall.service.impl;

import com.seqq.springboot_mall.entity.Admin;
import com.seqq.springboot_mall.mapper.AdminMapper;
import com.seqq.springboot_mall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> adminLogin(String adminName, String adminPassword) {
        return adminMapper.adminLogin(adminName, adminPassword);
    }
}
