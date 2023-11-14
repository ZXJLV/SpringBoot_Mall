package com.seqq.springboot_mall.service;

import com.seqq.springboot_mall.entity.Product;
import com.seqq.springboot_mall.entity.Productorder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductorderService {

    List<Productorder> selectProductordersByDate(String beginDate, String endDate);

    Integer selectProductordersSucceedCount();

    Integer selectProductordersOrderTotalArray(String beginDate, String endDate);

    List<Productorder> selectProductOrderByProductorderUserId(int productorderUserId);

    Productorder selectProductorderByProductorderCode(String productorderCode);

    int updateProductorderProductorderStatusByProductorderId(String productorderCode, String productorderConfirmDate);

    int updateProductorderProductorderStatusAndProductorderDeliveryDateByProductorderId(String productorderCode, String productorderDeliveryDate);

    int updateProductorderProductorderStatusAndProductorderPayDateByProductorderId(String productorderCode, String productorderPayDate);

    int deleteProductorderByProductorderCode(String productorderCode);

    Productorder selectProductorderByProductorderUserIdAndProductorderId(int productorderUserId);

    int insertProductorder(Productorder productorder);

    List<Productorder> selectProductorderByProductorderPayDateIsNullAndUserId(int userId);

    Productorder selectProductorderByProductorderId(int productorderId);

    List<Productorder> selectOrderTotalArray(String beginDate, String endDate);
    List<Productorder> selectOrderSuccessArray(String beginDate, String endDate);
    List<Productorder> selectOrderUnconfirmedArray(String beginDate, String endDate);
    List<Productorder> selectOrderNotShippedArray(String beginDate, String endDate);
}
