package com.example.demo.repository;

import com.example.demo.enums.Category;
import com.example.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieByTitle(String title);
    Optional<Movie> findMovieByCategory(Category category);
    Optional<Movie> findMovieByDirector(String director);
}
