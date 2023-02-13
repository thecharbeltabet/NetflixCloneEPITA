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
    @ElementCollection(targetClass=String.class)
    private List<String> genres;

    @Column(name = "ADDED")
    private Date added;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "POSTER_URL")
    private String PosterURL;

    @Column(name = "EXTERNAL_ID")
    private String external_id;

    public Movie() {}

    public Movie(int movie_id, String description, String PosterURL, List<String> genres, String title, Date added, String external_id) {
        this.movie_id = movie_id;
        this.description = description;
        this.PosterURL = PosterURL;
        this.genres = genres;
        this.title = title;
        this.added = added;
        this.external_id = external_id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                "title='" + title + '\'' +
                ", added=" + added +
                ", description='" + description + '\'' +
                ", PosterURL='" + PosterURL + '\'' +
                ", genres='" + genres + '\'' +
                ", external_id='" + external_id + '\'' +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }
}
