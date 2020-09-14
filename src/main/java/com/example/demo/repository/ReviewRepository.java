package com.example.demo.repository;

import com.example.demo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Modifying
    @Query("update Review u set u.reviewMessage = :reviewMessage where u.id = :id")
    void updateReview(@Param(value = "id") Long id, @Param(value = "reviewMessage") String reviewMessage);

    Review findById(Long id);
}
