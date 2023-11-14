package com.seqq.springboot_mall.service.impl;

import com.seqq.springboot_mall.entity.Productimage;
import com.seqq.springboot_mall.mapper.ProductimageMapper;
import com.seqq.springboot_mall.service.ProductimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductimageServiceImpl implements ProductimageService {

    @Autowired
    ProductimageMapper productimageMapper;

    @Override
    public List<Productimage> selectProductimageAll(int productimageProductId) {
        return productimageMapper.selectProductimageAll(productimageProductId);
    }

    @Override
    public List<Productimage> selectProductimageAll2(int productimageProductId) {
        return productimageMapper.selectProductimageAll2(productimageProductId);
    }


}
