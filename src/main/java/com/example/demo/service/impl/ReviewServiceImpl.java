package com.example.demo.service.impl;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository repository;

    @Autowired
    public void setProductRepository(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createReview(Review review) {
    repository.save(review);
    }

    @Override
    public void deleteReview(Review review) {
    repository.delete(review);
    }

    @Override
    public void updateReview(Long id, String reviewMessage) {
        Review updated = repository.findById(id);
        updated.setReviewMessage(reviewMessage);
        repository.save(updated);
    }

    @Override
    public List<Review> readReview() {
        return repository.findAll();
    }

    @Override
    public void addLikeReview(int reviewLikesCount,boolean isMovieLiked,Review review) {
       if (!isMovieLiked){
           review.setReviewLikesCount(reviewLikesCount++);
           review.setMovieLiked(true);
       }else{
           System.out.println("you already liked this");
       }
    }
}
