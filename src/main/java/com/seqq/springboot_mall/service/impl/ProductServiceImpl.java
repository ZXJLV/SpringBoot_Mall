package com.seqq.springboot_mall.service.impl;

import com.seqq.springboot_mall.entity.Product;
import com.seqq.springboot_mall.mapper.ProductMapper;
import com.seqq.springboot_mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public int selectProductCount() {
        return productMapper.selectProductCount();
    }

    @Override
    public List<Product> selectProductByProductId() {
        return productMapper.selectProductByProductId();
    }

    @Override
    public List<Product> selectProductAll(int productCategoryId) {
        return productMapper.selectProductAll(productCategoryId);
    }

    @Override
    public Product selectProductByProductorderitemProductId(int productId) {
        return productMapper.selectProductByProductorderitemProductId(productId);
    }

    @Override
    public List<Product> selectProductAndReviewByProductId(int productId) {
        return productMapper.selectProductAndReviewByProductId(productId);
    }

    @Override
    public Product selectProductAndCategoryByProductId(int productId) {
        return productMapper.selectProductAndCategoryByProductId(productId);
    }

    @Override
    public List<Product> selectProductAll2(int productId) {
        return productMapper.selectProductAll2(productId);
    }

    @Override
    public List<Product> selectProductByProductName(String productName) {
        return productMapper.selectProductByProductName(productName);
    }
}
