package com.seqq.springboot_mall.service;

import com.seqq.springboot_mall.entity.Productimage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductimageService {

    List<Productimage> selectProductimageAll(int productimageProductId);
    List<Productimage> selectProductimageAll2(int productimageProductId);
}
