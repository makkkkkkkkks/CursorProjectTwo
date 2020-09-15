package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.service.impl.MovieServiceImpl;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/admin")
@Data
@NoArgsConstructor
public class AdminController {

    private UserServiceImpl userService;
    private MovieServiceImpl movieService;

    @Autowired
    public AdminController(UserServiceImpl userService, MovieServiceImpl movieService) {
        this.userService = userService;
        this.movieService = movieService;
    }

    @PostMapping("/movie/add")
    public Movie addNewMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @DeleteMapping("/movie/delete/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}