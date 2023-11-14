package com.seqq.springboot_mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  private int productId;
  private String productName;
  private String productTitle;
  private double productPrice;
  private double productSalePrice;
  private String productCreateDate;
  private int productCategoryId;
  private int productIsEnabled;
  private List<Productimage> singleProductImageList;
  private List<Productimage> detailProductImageList;
  private String productReviewCount;
  private List<Review> reviewList;
  private Category category;
  private int productSaleCount;
}
