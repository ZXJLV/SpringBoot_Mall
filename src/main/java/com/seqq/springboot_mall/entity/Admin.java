package com.seqq.springboot_mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

  private int adminId;
  private String adminName;
  private String adminNickname;
  private String adminPassword;
  private String adminProfilePictureSrc;



}
