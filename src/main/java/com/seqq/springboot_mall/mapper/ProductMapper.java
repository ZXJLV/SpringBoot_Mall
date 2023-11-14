package com.seqq.springboot_mall.mapper;

import com.seqq.springboot_mall.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    // 查询商品数量
    int selectProductCount();

    List<Product> selectProductByProductId();

    List<Product> selectProductAll(@Param("productCategoryId") int productCategoryId);

    Product selectProductByProductorderitemProductId(@Param("productId") int productId);

    List<Product> selectProductAndReviewByProductId(@Param("productId") int productId);

    Product selectProductAndCategoryByProductId(@Param("productId") int productId);

    List<Product> selectProductAll2(@Param("productId") int productId);

    List<Product> selectProductByProductName(@Param("productName") String productName);
}
