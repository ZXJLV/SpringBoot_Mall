package com.seqq.springboot_mall.mapper;

import com.seqq.springboot_mall.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    Integer selectUserCount();

    User userLogin(@Param("userName") String userName, @Param("userPassword") String userPassword);

    int insertUser(@Param("userName") String userName, @Param("userPassword") String userPassword, @Param("userNickName") String userNickName, @Param("userBirthday") String userBirthday, @Param("userGender") int userGender, @Param("userAddress") int userAddress);

    User selectUserByUserId(@Param("userId") int userId);
}
