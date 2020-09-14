package com.example.demo.service.impl;

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
        return movieRepository.getMovieById(id);
    }

    @Override
    public Movie addRateMovie(Long id) {
        return null;
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void updateMovie(Long id) {

    }
}
