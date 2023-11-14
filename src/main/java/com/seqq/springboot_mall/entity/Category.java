package com.seqq.springboot_mall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

  private int categoryId;
  private String categoryName;
  private String categoryImageSrc;
  private List<Product> productList;

}
