package com.example.demo.service;

import com.example.demo.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public List<Movie> findAllMovies();

    public Optional<Movie> findMovieById(Long id);

    public Movie addRateMovie(Long id);

    public void addMovie(Movie movie);

    public void deleteMovie(Long id);

    public void updateMovie(Long id);
}
