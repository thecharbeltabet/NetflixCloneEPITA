//package com.example.javaservernetflix2023.services;
//
//import com.example.javaservernetflix2023.datamodel.Movie;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.junit.Before;
//import org.junit.jupiter.api.*;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MovieDAOTests {
//    private MovieDAO movieDAO;
//
//    @Before
//    public void setUp() {
//        // initialize movieDAO instance
//        movieDAO = new MovieDAO();
//    }
//
//    @Test
//    public void testGetAllMovies() {
//        List<Movie> movies = movieDAO.getAllMovies();
//        assertNotNull(movies);
//        assertTrue(movies.size() > 0);
//    }
//
//    @Test
//    public void testGetMovieById() {
//        int id = 1;
//        Movie movie = movieDAO.getMovie(id);
//        assertNotNull(movie);
//        assertEquals(id, movie.getMovie_id());
//    }
//
//    @Test
//    public void testAddMovie() {
//        Movie newMovie = new Movie(0, "New Movie", "Description", "Action", "poster.png", "backdrop.png", "2022-01-01", 0);
//        movieDAO.addMovie(newMovie);
//        assertTrue(id > 0);
//
//        Movie addedMovie = movieDAO.getMovie(id);
//        assertNotNull(addedMovie);
//        assertEquals(newMovie.getTitle(), addedMovie.getTitle());
//    }
//
//    @Test
//    public void testUpdateMovie() {
//        // get a movie to update
//        int id = 1;
//        Movie movie = movieDAO.getMovieById(id);
//        assertNotNull(movie);
//
//        // update the movie's title and genre
//        String newTitle = "Updated Title";
//        String newGenre = "Drama";
//        movie.setTitle(newTitle);
//        movie.setGenre(newGenre);
//
//        // update the movie in the database
//        boolean success = movieDAO.updateMovie(movie);
//        assertTrue(success);
//
//        // retrieve the updated movie from the database and verify the fields
//        Movie updatedMovie = movieDAO.getMovieById(id);
//        assertNotNull(updatedMovie);
//        assertEquals(newTitle, updatedMovie.getTitle());
//        assertEquals(newGenre, updatedMovie.getGenre());
//    }
//
////    @Test
////    public void testDeleteMovie() {
////        // add a movie to delete
////        Movie newMovie = new Movie(0, "New Movie", "Description", "Action", "poster.png", "backdrop.png", "2022-01-01", 0);
////        int id = movieDAO.addMovie(newMovie);
////        assertTrue(id > 0);
////
////        // delete the movie from the database
////        boolean success = movieDAO.deleteMovie(id);
////        assertTrue(success);
////
////        // try to retrieve the deleted movie and verify that it's null
////        Movie deletedMovie = movieDAO.getMovie(id);
////        assertNull(deletedMovie);
////    }
//}