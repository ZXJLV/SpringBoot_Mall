package com.seqq.springboot_mall.mapper;

import com.seqq.springboot_mall.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<Category> selectCategoryAll();

    Category selectCategoryByProductCategoryId(@Param("productCategoryId") int productCategoryId);

}
