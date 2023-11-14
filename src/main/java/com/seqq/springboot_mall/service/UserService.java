package com.seqq.springboot_mall.service;

import com.seqq.springboot_mall.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    Integer selectUserCount();

    User userLogin(String userName, String userPassword);

    int insertUser(String userName, String userPassword, String userNickName, String userBirthday, int userGender, int userAddress);

    User selectUserByUserId(int userId);
}
