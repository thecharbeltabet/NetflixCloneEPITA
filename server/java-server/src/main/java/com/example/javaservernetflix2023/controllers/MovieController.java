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

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/movies/comedy")
    public List<Movie> getAllComedyMovies(){
        return movieRepository.getAllComedyMovies();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/movies/romance")
    public List<Movie> getAllRomanceMovies(){
        return movieRepository.getAllRomanceMovies();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/movies/horror")
    public List<Movie> getAllHorrorMovies(){
        return movieRepository.getAllHorrorMovies();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/movies/documentary")
    public List<Movie> getAllDocumentaries(){
        return movieRepository.getAllDocumentaries();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/movies/top-rated")
    public List<Movie> getTopRatedMovies(){
        return movieRepository.getTopRatedMovies();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/movies/trending")
    public List<Movie> getTrendingMovies(){
        return movieRepository.getTrendingMovies();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/movies/top10")
    public List<Movie> getTopViewed(){
        return movieRepository.getTopViewedMovies();
    }



}
