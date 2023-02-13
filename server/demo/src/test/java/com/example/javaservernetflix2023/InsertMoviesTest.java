package com.example.javaservernetflix2023;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.example.javaservernetflix2023.configuration.Configuration;
import com.example.javaservernetflix2023.datamodel.Movie;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

import javax.inject.Named;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Configuration.class)
@RunWith(SpringRunner.class)
public class InsertMoviesTest {

    @Autowired
    @Named("postgresDataSource")
    DataSource dataSource;

    @Test
    public void testPostgresDataSource() throws Exception {
        assertNotNull(dataSource);
        Connection connection = dataSource.getConnection();
        assertNotNull(connection);
        connection.close();
    }

    @Test
    public void testInsertIntoDatabase() throws Exception {
        List<Movie> movies = readMoviesFromJson();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        for (Movie movie : movies) {
            System.out.println(movie);
            statement.executeUpdate("INSERT INTO MOVIES (movie_id, title, genres, added, description, PosterURL,external_id) VALUES ('" + movie.getMovie_id() + "', '" + movie.getTitle() + "', '" + movie.getGenres() + "', '" + movie.getAdded() + "', '" + movie.getDescription() + "', '" + movie.getPosterURL() + "', '" + movie.getExternal_id() + "')");
        }
        connection.close();
    }

    private List<Movie> readMoviesFromJson() throws Exception {
        List<Movie> movies = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/movies.json"));
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            sb.append(line);
            line = reader.readLine();
        }
        reader.close();

        Gson gson = new Gson();
        Type movieListType = new TypeToken<List<Movie>>(){}.getType();
        movies = gson.fromJson(sb.toString(), movieListType);
        printMovies(movies);
        return movies;
    }

    private void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }


}
