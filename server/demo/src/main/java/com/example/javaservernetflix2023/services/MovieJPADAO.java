package com.example.javaservernetflix2023.services;

import com.example.javaservernetflix2023.datamodel.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

// This is the DAO class for the Movie class
@Service
public class MovieJPADAO {

    private final SessionFactory factory;

    public MovieJPADAO(SessionFactory factory) {
        this.factory = factory;
    }


    //Update movie
    public void updateMovie(Movie movie) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(movie);
        transaction.commit();
    }

    //delete a movie by ID
    public void deleteMovie(int movie_id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Movie movie = session.get(Movie.class, movie_id);
        session.delete(movie);
        transaction.commit();
    }

    public Movie getMovie(int movie_id) {
        Session session = factory.openSession();
        Movie movie = session.get(Movie.class, movie_id);
        session.close();
        return movie;
    }

    //Get movie by Title
    public Movie getMovieByTitle(String title) {
        Session session = factory.openSession();
        Query<Movie> query = session.createQuery("from Movie where title = :title");
        query.setParameter("title", title);
        session.close();
        return query.uniqueResult();
    }

    public void addMovie(Movie movie) {
        Session session = factory.openSession();
        System.out.println(movie);
        Transaction transaction = session.beginTransaction();
        session.save(session.merge(movie));
        transaction.commit();
    }

    public List<Movie> getAllMovies() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Movie");
        List<Movie> movies = query.list();
        tx.commit();
        session.close();
        return movies;
    }

    public List<Movie> getAllRecentMovies() {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Movie where release_date > 2010");
        List<Movie> movies = query.list();
        tx.commit();
        session.close();
        return movies;
    }

    // Get all action movies
    public List<Movie> getAllActionMovies() {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Movie where genre = 'Action'");
        List<Movie> movies = query.list();
        tx.commit();
        session.close();
        return movies;
    }

    // Delete all movies
    public void deleteAllMovies() {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("delete from Movie");
        query.executeUpdate();
        tx.commit();
        session.close();
    }


    public Session getSession() {
        Session currentSession = null;
        try {
            currentSession = this.factory.getCurrentSession();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (currentSession != null && currentSession.isOpen()) {
            return currentSession;
        } else {
            return this.factory.openSession();
        }
    }

}


