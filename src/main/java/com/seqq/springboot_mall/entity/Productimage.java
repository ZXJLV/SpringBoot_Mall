package com.seqq.springboot_mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productimage {

  private int productimageId;
  private int productimageType;
  private String productimageSrc;
  private int productimageProductId;



}
