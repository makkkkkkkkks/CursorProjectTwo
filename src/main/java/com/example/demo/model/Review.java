package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "Reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "movie_id")
    private long movieId;

    @Column(name = "review_message")
    @Type(type = "text")
    private String reviewMessage;

    @Column(name = "is_movie_liked")
    private boolean isMovieLiked;

    @Column(name = "review_likes_count")
    private int reviewLikesCount;

    @ManyToOne
    @JoinColumn(name = "reviewer")
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "movie")
    private Movie movie;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public boolean isMovieLiked() {
        return isMovieLiked;
    }

    public void setMovieLiked(boolean movieLiked) {
        isMovieLiked = movieLiked;
    }

    public int getReviewLikesCount() {
        return reviewLikesCount;
    }

    public void setReviewLikesCount(int reviewLikesCount) {
        this.reviewLikesCount = reviewLikesCount;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
