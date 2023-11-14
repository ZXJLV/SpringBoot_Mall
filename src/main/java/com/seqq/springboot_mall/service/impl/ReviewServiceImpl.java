package com.seqq.springboot_mall.service.impl;

import com.seqq.springboot_mall.entity.Review;
import com.seqq.springboot_mall.mapper.ReviewMapper;
import com.seqq.springboot_mall.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewMapper reviewMapper;


    @Override
    public Review selectReviewByReviewOrderItemId(int reviewOrderItemId) {
        return reviewMapper.selectReviewByReviewOrderItemId(reviewOrderItemId);
    }

    @Override
    public int insertReview(Review review) {
        return reviewMapper.insertReview(review);
    }

    @Override
    public int selectReviewCountByProductId(int productId) {
        return reviewMapper.selectReviewCountByProductId(productId);
    }

    @Override
    public List<Review> selectReviewByProductId(int productId) {
        return reviewMapper.selectReviewByProductId(productId);
    }
}
