package com.seqq.springboot_mall.service.impl;

import com.seqq.springboot_mall.entity.User;
import com.seqq.springboot_mall.mapper.UserMapper;
import com.seqq.springboot_mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer selectUserCount() {
        return userMapper.selectUserCount();
    }

    @Override
    public User userLogin(String userName, String userPassword) {
        return userMapper.userLogin(userName, userPassword);
    }

    @Override
    public int insertUser(String userName, String userPassword, String userNickName, String userBirthday, int userGender, int userAddress) {
        return userMapper.insertUser(userName, userPassword, userNickName, userBirthday, userGender, userAddress);
    }

    @Override
    public User selectUserByUserId(int userId) {
        return userMapper.selectUserByUserId(userId);
    }
}
