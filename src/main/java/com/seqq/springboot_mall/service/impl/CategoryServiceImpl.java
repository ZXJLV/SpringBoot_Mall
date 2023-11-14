package com.seqq.springboot_mall.service.impl;

import com.seqq.springboot_mall.entity.Category;
import com.seqq.springboot_mall.mapper.CategoryMapper;
import com.seqq.springboot_mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> selectCategoryAll() {
        return categoryMapper.selectCategoryAll();
    }

    @Override
    public Category selectCategoryByProductCategoryId(int productCategoryId) {
        return categoryMapper.selectCategoryByProductCategoryId(productCategoryId);
    }
}
