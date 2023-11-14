package com.seqq.springboot_mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private int userId;
  private String userName;
  private String userNickName;
  private String userPassword;
  private String userRealname;
  private int userGender;
  private String userBirthday;
  private String userAddress;
  private String userHomePlace;
  private String userProfilePictureSrc;



}
