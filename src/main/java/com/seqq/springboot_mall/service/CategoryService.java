package com.seqq.springboot_mall.service;

import com.seqq.springboot_mall.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryService {

    List<Category> selectCategoryAll();

    Category selectCategoryByProductCategoryId(int productCategoryId);
}
