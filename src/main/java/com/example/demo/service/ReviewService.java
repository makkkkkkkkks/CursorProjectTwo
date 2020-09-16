package com.example.demo.service;

import com.example.demo.model.Review;

import java.util.List;

public interface ReviewService {
    void createReview(Review review);
    void deleteReview(Review review);
    void updateReview(Long id,String reviewMessage);
    List<Review> readReview();
    void addLikeReview(int reviewLikesCount,boolean isMovieLiked,Review review);
}
