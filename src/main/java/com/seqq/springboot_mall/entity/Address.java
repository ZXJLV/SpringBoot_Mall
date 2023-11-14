package com.seqq.springboot_mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  private String addressAreaId;
  private String addressName;
  private String addressRegionId;


}
