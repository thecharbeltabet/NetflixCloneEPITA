package com.example.javaservernetflix2023.datamodel;


import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "SEEN_MOVIES")
public class SeenMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SEEN_MOVIE_ID")
    private int seenMovieId;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;

    public SeenMovie() {
    }

    public SeenMovie(Date date, int seenMovieId, User user, Movie movie) {
        this.date = date;
        this.seenMovieId = seenMovieId;
        this.user = user;
        this.movie = movie;
    }

    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeenMovieId() {
        return seenMovieId;
    }

    public void setSeenMovieId(int seenMovieId) {
        this.seenMovieId = seenMovieId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    // The toString() method
    @Override
    public String toString() {
        return "SeenMovie{" +
                "date=" + date +
                ", seenMovieId=" + seenMovieId +
                ", user=" + user +
                ", movie=" + movie +
                '}';
    }

}
