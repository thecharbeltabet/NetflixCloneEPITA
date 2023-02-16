package com.example.javaservernetflix2023;

import com.example.javaservernetflix2023.services.MovieDAO;
import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.example.javaservernetflix2023.configuration.Configuration;
import com.example.javaservernetflix2023.datamodel.Movie;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Configuration.class)
@RunWith(SpringRunner.class)
public class InsertMoviesTest {

    @Autowired
    @Named("postgresDataSource")
    DataSource dataSource;


    @Inject
    @Named("postgresSessionFactory")
    SessionFactory sf;

    @Test
    public void testPostgresDataSource() throws Exception {
        assertNotNull(dataSource);
        Connection connection = dataSource.getConnection();
        assertNotNull(connection);
        connection.close();
    }

    @Test
    public void jsonToMovieObjects() throws IOException, ParseException {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        String genresofMovies[] = {"trending", "topRated", "romance", "horror", "documentary", "comedy", "action"};


        int counter = 0;

        for (String genre : genresofMovies) {
            try(FileReader reader = new FileReader("src/main/resources/" + genre + "Movies.json")) {
                //Read JSON file
                Object obj = jsonParser.parse(reader);
                counter++;
                System.out.println("This is the counter:"+ counter);

                JSONArray moviesList = (JSONArray) obj;

                moviesList.forEach(movie -> {
                    parseMovieObject((JSONObject) movie);
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

            }


    private void parseMovieObject(@NotNull JSONObject movie) {
        //Get movie object within list
        JSONObject movieObject = (JSONObject) movie.get("movie");

        System.out.println(movieObject);


        String overview = movieObject.containsKey("overview") ? (String) movieObject.get("overview") : "";
        String backdropURL = movieObject.containsKey("backdrop_path") ? (String) movieObject.get("backdrop_path") : "";
        String genre = (String) movieObject.get("genre");
        String poster_path = (String) movieObject.get("poster_path");
        String release_date = (String) movieObject.get("release_date");
        String title = (String) movieObject.get("title");




        System.out.println("Title: " + title);
        System.out.println("Overview: " + overview);
        System.out.println("Poster Path: " + poster_path);
        System.out.println("Backdrop Path: " + backdropURL);
        System.out.println("Release Date: " + release_date);
        System.out.println("Genre: " + genre);

        Movie movie1 = new Movie();

        movie1.setTitle(title);
        movie1.setDescription(overview);
        movie1.setPosterURL(poster_path);
        movie1.setBackdropURL(backdropURL);
        movie1.setAdded(release_date);
        movie1.setGenre(genre);
        movie1.setViews(0);
        movieObject = (JSONObject) movie.get("movie");


        try (Session session = sf.openSession()) {
            MovieDAO movieDAO = new MovieDAO(sf);
            movieDAO.addMovie(movie1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
