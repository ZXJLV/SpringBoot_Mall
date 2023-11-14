package com.seqq.springboot_mall.service;

import com.seqq.springboot_mall.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    int selectProductCount();

    List<Product> selectProductByProductId();

    List<Product> selectProductAll(int productCategoryId);

    Product selectProductByProductorderitemProductId(int productId);

    List<Product> selectProductAndReviewByProductId(int productId);

    Product selectProductAndCategoryByProductId(int productId);

    List<Product> selectProductAll2(int productId);

    List<Product> selectProductByProductName(String productName);
}
