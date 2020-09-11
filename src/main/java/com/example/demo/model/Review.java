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
}
