package com.example.demo.service.impl;

import com.example.demo.enums.Category;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }

    @Override
    public Optional<Movie> findMovieByCategory(Category category) {
        return movieRepository.findMovieByCategory(category);
    }

    @Override
    public Optional<Movie> findMovieByDirector(String director) {
        return movieRepository.findMovieByDirector(director);
    }

    @Override
    public Movie addRateMovie(Long id) {
        return null;
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie updateMovie(Long id, String title, Category category, String directory, String shortDescription) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setTitle(title);
                    movie.setCategory(category);
                    movie.setDirector(directory);
                    movie.setShortDescription(shortDescription);
                    return movieRepository.save(movie);
                }).orElseThrow();
    }
}