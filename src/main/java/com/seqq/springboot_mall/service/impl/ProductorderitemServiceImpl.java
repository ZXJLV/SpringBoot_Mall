package com.seqq.springboot_mall.service.impl;

import com.seqq.springboot_mall.entity.Productorderitem;
import com.seqq.springboot_mall.mapper.ProductorderMapper;
import com.seqq.springboot_mall.mapper.ProductorderitemMapper;
import com.seqq.springboot_mall.service.ProductorderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductorderitemServiceImpl implements ProductorderitemService {

    @Autowired
    ProductorderitemMapper productorderitemMapper;

    @Override
    public List<Productorderitem> selectProductorderitemByProductorderitemOrderId(int productorderitemOrderId) {
        return productorderitemMapper.selectProductorderitemByProductorderitemOrderId(productorderitemOrderId);
    }

    @Override
    public List<Productorderitem> selectProductorderitemsByProductorderitemUserId(int productorderitemUserId) {
        return productorderitemMapper.selectProductorderitemsByProductorderitemUserId(productorderitemUserId);
    }

    @Override
    public Productorderitem selectProductorderitemsByProductorderitemId(int productorderitemId) {
        return productorderitemMapper.selectProductorderitemsByProductorderitemId(productorderitemId);
    }

    @Override
    public int deleteProductorderitemByProductorderitemOrderId(int productorderItemOrderId) {
        return productorderitemMapper.deleteProductorderitemByProductorderitemOrderId(productorderItemOrderId);
    }

    @Override
    public int selectProductorderitemNumberSumBypProductId(int productId) {
        return productorderitemMapper.selectProductorderitemNumberSumBypProductId(productId);
    }

    @Override
    public int insertProductorderitem(Productorderitem productorderitem) {
        return productorderitemMapper.insertProductorderitem(productorderitem);
    }

}
