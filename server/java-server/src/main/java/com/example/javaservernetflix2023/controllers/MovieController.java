package com.example.javaservernetflix2023.controllers;


import com.example.javaservernetflix2023.datamodel.Movie;
import com.example.javaservernetflix2023.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieRepository.getAllMovies();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/movies/action")
    public List<Movie> getAllActionMovies(){
        return movieRepository.getAllActionMovies();
    }

}
