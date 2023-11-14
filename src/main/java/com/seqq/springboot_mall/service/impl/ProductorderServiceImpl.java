package com.seqq.springboot_mall.service.impl;

import com.seqq.springboot_mall.entity.Product;
import com.seqq.springboot_mall.entity.Productorder;
import com.seqq.springboot_mall.mapper.ProductorderMapper;
import com.seqq.springboot_mall.service.ProductorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductorderServiceImpl implements ProductorderService {

    @Autowired
    ProductorderMapper productorderMapper;

    @Override
    public List<Productorder> selectProductordersByDate(String beginDate, String endDate) {
        return productorderMapper.selectProductordersByDate(beginDate, endDate);
    }

    @Override
    public Integer selectProductordersSucceedCount() {
        return productorderMapper.selectProductordersSucceedCount();
    }

    @Override
    public Integer selectProductordersOrderTotalArray(String beginDate, String endDate) {
        return productorderMapper.selectProductordersOrderTotalArray(beginDate, endDate);
    }

    @Override
    public List<Productorder> selectProductOrderByProductorderUserId(int productorderUserId) {
        return productorderMapper.selectProductOrderByProductorderUserId(productorderUserId);
    }

    @Override
    public Productorder selectProductorderByProductorderCode(String productorderCode) {
        return productorderMapper.selectProductorderByProductorderCode(productorderCode);
    }

    @Override
    public int updateProductorderProductorderStatusByProductorderId(String productorderCode, String productorderConfirmDate) {
        return productorderMapper.updateProductorderProductorderStatusByProductorderId(productorderCode, productorderConfirmDate);
    }

    @Override
    public int updateProductorderProductorderStatusAndProductorderDeliveryDateByProductorderId(String productorderCode, String productorderDeliveryDate) {
        return productorderMapper.updateProductorderProductorderStatusAndProductorderDeliveryDateByProductorderId(productorderCode, productorderDeliveryDate);
    }

    @Override
    public int updateProductorderProductorderStatusAndProductorderPayDateByProductorderId(String productorderCode, String productorderPayDate) {
        return productorderMapper.updateProductorderProductorderStatusAndProductorderPayDateByProductorderId(productorderCode, productorderPayDate);
    }

    @Override
    public int deleteProductorderByProductorderCode(String productorderCode) {
        return productorderMapper.deleteProductorderByProductorderCode(productorderCode);
    }

    @Override
    public Productorder selectProductorderByProductorderUserIdAndProductorderId(int productorderUserId) {
        return productorderMapper.selectProductorderByProductorderUserIdAndProductorderId(productorderUserId);
    }

    @Override
    public int insertProductorder(Productorder productorder) {
        return productorderMapper.insertProductorder(productorder);
    }

    @Override
    public List<Productorder> selectProductorderByProductorderPayDateIsNullAndUserId(int userId) {
        return productorderMapper.selectProductorderByProductorderPayDateIsNullAndUserId(userId);
    }

    @Override
    public Productorder selectProductorderByProductorderId(int productorderId) {
        return productorderMapper.selectProductorderByProductorderId(productorderId);
    }

    @Override
    public List<Productorder> selectOrderTotalArray(String beginDate, String endDate) {
        return productorderMapper.selectOrderTotalArray(beginDate, endDate);
    }

    @Override
    public List<Productorder> selectOrderSuccessArray(String beginDate, String endDate) {
        return productorderMapper.selectOrderSuccessArray(beginDate, endDate);
    }

    @Override
    public List<Productorder> selectOrderUnconfirmedArray(String beginDate, String endDate) {
        return productorderMapper.selectOrderUnconfirmedArray(beginDate, endDate);
    }

    @Override
    public List<Productorder> selectOrderNotShippedArray(String beginDate, String endDate) {
        return productorderMapper.selectOrderNotShippedArray(beginDate, endDate);
    }

}
