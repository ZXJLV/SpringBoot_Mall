package com.seqq.springboot_mall.service;

import com.seqq.springboot_mall.entity.Productorderitem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductorderitemService {

    List<Productorderitem> selectProductorderitemByProductorderitemOrderId(int productorderitemOrderId);

    List<Productorderitem> selectProductorderitemsByProductorderitemUserId(int productorderitemUserId);
    Productorderitem selectProductorderitemsByProductorderitemId(int productorderitemId);

    int deleteProductorderitemByProductorderitemOrderId(int productorderItemOrderId);

    int selectProductorderitemNumberSumBypProductId(int productId);

    int insertProductorderitem(Productorderitem productorderitem);
}
