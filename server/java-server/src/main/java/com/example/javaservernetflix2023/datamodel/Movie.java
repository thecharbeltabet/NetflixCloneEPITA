package com.example.javaservernetflix2023.datamodel;



import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private int movie_id;

    @Column(name = "TITLE")
    private String title;


    @Column(name = "GENRES")
    private String genre;

    @Column(name = "ADDED")
    private String added;

    @Column(name = "DESCRIPTION" , length = 2048)
    private String description;

    @Column(name = "POSTER_URL")
    private String PosterURL;

    @Column(name = "BACKDROP_URL")
    private String backdropURL;


    @Column(name = "VIEWS")
    private int views;

    public Movie() {}

    public Movie(int movie_id, String description, String PosterURL,String backdropURL, String genre, String title, String added, int views) {
        this.movie_id = movie_id;
        this.description = description;
        this.PosterURL = PosterURL;
        this.backdropURL = backdropURL;
        this.genre = genre;
        this.title = title;
        this.added = added;
        this.views = views;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                "title='" + title + '\'' +
                ", added=" + added +
                ", description='" + description + '\'' +
                ", PosterURL='" + PosterURL + '\'' +
                ", backdropURL='" + backdropURL + '\'' +
                ", genres='" + genre + '\'' +
                '}';
    }

    public int getMovie_id(){
        return movie_id;
    }

    public void setMovie_id(int movie_id){
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterURL() {
        return PosterURL;
    }

    public void setPosterURL(String PosterURL) {
        this.PosterURL = PosterURL;
    }

    public String getBackdropURL() {
        return backdropURL;
    }

    public void setBackdropURL(String backdropURL) {
        this.backdropURL = backdropURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

}
