package com.example.javaservernetflix2023;

import com.example.javaservernetflix2023.configuration.Configuration;
import com.example.javaservernetflix2023.datamodel.Movie;
import com.example.javaservernetflix2023.services.MovieJPADAO;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Configuration.class)
public class MovieDAOTests {

    @Inject
    @Named("postgresSessionFactory")
    SessionFactory sf;

    private static MovieJPADAO movieJPADAO;

    private static Movie movie1;
    private static Movie movie2;
    private static Movie movie3;

    @BeforeEach
    public void setup() {
        movieJPADAO = new MovieJPADAO(sf);

        List<String> genres1 = new ArrayList<>();
        genres1.add("Drama");
        genres1.add("Crime");
        movie1 = new Movie();
        movie1.setMovie_id(1);
        movie1.setTitle("GIJOE");
        movie1.setAdded(new Date());
        movie1.setGenres(genres1);
        movie1.setPosterURL("URL");
        movie1.setDescription("Hello its me");
        movie1.setExternal_id("112");
        System.out.println(movie1);

        List<String> genres2 = new ArrayList<>();
        genres2.add("Crime");
        genres2.add("SciFi");
        movie2 = new Movie(2, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", "poster2", genres2, "The Godfather", new Date(), "2");
        System.out.println(movie2);

        List<String> genres3 = new ArrayList<>();
        genres3.add("Action");
        movie3 = new Movie(3, "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.", "poster3", genres3, "The Dark Knight", new Date(), "3");
        System.out.println(movie3);

    }

    @AfterEach
    public void tearDown() {
        movieJPADAO.deleteAllMovies();
    }

    @Test
    public void testAddMovie() {
        System.out.println(movie1);
        movieJPADAO.addMovie(movie1);
        movieJPADAO.addMovie(movie2);
        movieJPADAO.addMovie(movie3);

        List<Movie> movies = movieJPADAO.getAllMovies();
        assertEquals(3, movies.size());
        assertTrue(movies.contains(movie1));
        assertTrue(movies.contains(movie2));
        assertTrue(movies.contains(movie3));
    }

    @Test
    public void testGetMovieById() {
        movieJPADAO.addMovie(movie1);

        Movie result = movieJPADAO.getMovie(movie1.getMovie_id());
        assertEquals(movie1, result);
    }

    @Test
    public void testUpdateMovie() {
        movieJPADAO.addMovie(movie1);

        movie1.setTitle("The Shawshank Redemption Updated");
        movieJPADAO.updateMovie(movie1);

        Movie result = movieJPADAO.getMovie(movie1.getMovie_id());
        assertEquals("The Shawshank Redemption Updated", result.getTitle());
    }

    @Test
    public void testDeleteMovie() {
        movieJPADAO.addMovie(movie1);
        movieJPADAO.addMovie(movie2);
        movieJPADAO.addMovie(movie3);

        movieJPADAO.deleteMovie(movie2.getMovie_id());

        List<Movie> movies = movieJPADAO.getAllMovies();
        assertEquals(2, movies.size());
        assertTrue(movies.contains(movie1));
        assertTrue(movies.contains(movie3));

    }

    @Test
    public void testGetAllMovies() {
        movieJPADAO.addMovie(movie1);
        movieJPADAO.addMovie(movie2);
        movieJPADAO.addMovie(movie3);

        List<Movie> movies = movieJPADAO.getAllMovies();
        assertEquals(3, movies.size());
        assertTrue(movies.contains(movie1));
        assertTrue(movies.contains(movie2));
        assertTrue(movies.contains(movie3));
    }
}





