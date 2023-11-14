package com.seqq.springboot_mall.mapper;

import com.seqq.springboot_mall.entity.Productorderitem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductorderitemMapper {

    List<Productorderitem> selectProductorderitemByProductorderitemOrderId(@Param("productorderitemOrderId") int productorderitemOrderId);
    List<Productorderitem> selectProductorderitemsByProductorderitemUserId(@Param("productorderitemUserId") int productorderitemUserId);

    Productorderitem selectProductorderitemsByProductorderitemId(@Param("productorderitemId") int productorderitemId);

    int deleteProductorderitemByProductorderitemOrderId(@Param("productorderItemOrderId") int productorderItemOrderId);

    int selectProductorderitemNumberSumBypProductId(@Param("productId") int productId);

    int insertProductorderitem(Productorderitem productorderitem);
}
