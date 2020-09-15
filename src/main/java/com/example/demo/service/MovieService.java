package com.example.demo.service;

import com.example.demo.enums.Category;
import com.example.demo.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public List<Movie> findAllMovies();

    public Optional<Movie> findMovieById(Long id);

    public Optional<Movie> findMovieByTitle(String title);

    public Optional<Movie> findMovieByCategory(Category category);

    public Optional<Movie> findMovieByDirector(String director);

    public Movie addRateMovie(Long id);

    public Movie addMovie(Movie movie);

    public void deleteMovie(Long id);

    public Movie updateMovie(Long id, String title, Category category, String directory, String shortDescription);
}
