package com.seqq.springboot_mall.mapper;

import com.seqq.springboot_mall.entity.Productimage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductimageMapper {

    List<Productimage> selectProductimageAll(@Param("productimageProductId") int productimageProductId);
    List<Productimage> selectProductimageAll2(@Param("productimageProductId") int productimageProductId);

}
