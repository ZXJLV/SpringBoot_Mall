package com.seqq.springboot_mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productorderitem {

    private int productOrderItemId;
    private int productOrderItemNumber;
    private double productOrderItemPrice;
    private int productOrderItemProductId;
    private int productOrderItemOrderId;
    private int productOrderItemUserId;
    private String productOrderItemUserMessage;
    private Product product;
    private List<Productimage> productimageList;
    private boolean isReview;
}
