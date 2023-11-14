package com.seqq.springboot_mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productorder {

  private int productorderId;
  private String productOrderCode;
  private String productOrderAddress;
  private String productOrderDetailAddress;
  private String productOrderPost;
  private String productOrderReceiver;
  private String productOrderMobile;
  private String productOrderPayDate;
  private String productOrderDeliveryDate;
  private String productOrderConfirmDate;
  private int productOrderStatus;
  private int productOrderUserId;
  private List<Productorderitem> productOrderItemList;
  private int dailyTotal;
  private String orderDate;
  private int orderCount;
  private int orderCount2;
  private int orderCount3;

}
