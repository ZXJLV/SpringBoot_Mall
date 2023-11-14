package com.seqq.springboot_mall.mapper;

import com.seqq.springboot_mall.entity.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {

    Review selectReviewByReviewOrderItemId(@Param("reviewOrderItemId") int reviewOrderItemId);

    List<Review> selectReviewByProductId(@Param("productId") int productId);

    int insertReview(Review review);

    int selectReviewCountByProductId(@Param("productId") int productId);

}
