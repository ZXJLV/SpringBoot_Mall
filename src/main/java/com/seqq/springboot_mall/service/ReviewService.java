package com.seqq.springboot_mall.service;

import com.seqq.springboot_mall.entity.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewService {

    Review selectReviewByReviewOrderItemId(int reviewOrderItemId);

    int insertReview(Review review);

    int selectReviewCountByProductId(int productId);

    List<Review> selectReviewByProductId(int productId);
}
