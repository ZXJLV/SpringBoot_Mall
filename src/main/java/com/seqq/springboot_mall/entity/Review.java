package com.seqq.springboot_mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

  private int reviewId;
  private String reviewContent;
  private String reviewCreatedate;
  private int reviewUserId;
  private int reviewProductId;
  private int reviewOrderItemId;
  private User reviewUser;

}
