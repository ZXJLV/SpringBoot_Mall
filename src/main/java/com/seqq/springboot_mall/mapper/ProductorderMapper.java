package com.seqq.springboot_mall.mapper;

import com.seqq.springboot_mall.entity.Product;
import com.seqq.springboot_mall.entity.Productorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductorderMapper {

    List<Productorder> selectProductordersByDate(@Param("beginDate") String beginDate, @Param("endDate") String endDate);

    Integer selectProductordersSucceedCount();

    Integer selectProductordersOrderTotalArray(@Param("beginDate") String beginDate, @Param("endDate") String endDate);

    List<Productorder> selectProductOrderByProductorderUserId(@Param("productorderUserId") int productorderUserId);

    Productorder selectProductorderByProductorderCode(@Param("productorderCode") String productorderCode);

    int updateProductorderProductorderStatusByProductorderId(@Param("productorderCode") String productorderCode, @Param("productorderConfirmDate") String productorderConfirmDate);
    int updateProductorderProductorderStatusAndProductorderDeliveryDateByProductorderId(@Param("productorderCode") String productorderCode, @Param("productorderDeliveryDate") String productorderDeliveryDate);
    int updateProductorderProductorderStatusAndProductorderPayDateByProductorderId(@Param("productorderCode") String productorderCode, @Param("productorderPayDate") String productorderPayDate);

    int deleteProductorderByProductorderCode(@Param("productorderCode") String productorderCode);

    Productorder selectProductorderByProductorderUserIdAndProductorderId(@Param("productorderUserId") int productorderUserId);

    int insertProductorder(Productorder productorder);

    List<Productorder> selectProductorderByProductorderPayDateIsNullAndUserId(@Param("userId") int userId);

    Productorder selectProductorderByProductorderId(@Param("productorderId") int productorderId);

    List<Productorder> selectOrderTotalArray(@Param("beginDate") String beginDate, @Param("endDate") String endDate);
    List<Productorder> selectOrderSuccessArray(@Param("beginDate") String beginDate, @Param("endDate") String endDate);
    List<Productorder> selectOrderUnconfirmedArray(@Param("beginDate") String beginDate, @Param("endDate") String endDate);
    List<Productorder> selectOrderNotShippedArray(@Param("beginDate") String beginDate, @Param("endDate") String endDate);

}



