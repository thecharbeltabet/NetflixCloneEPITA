package com.example.javaservernetflix2023.datamodel;

import java.util.Date;

public class Movie {

    private String title;

    private Date added;

    private String external_id;

    public Movie(String title, Date added, String external_id) {
        this.title = title;
        this.added = added;
        this.external_id = external_id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", added=" + added +
                ", external_id='" + external_id + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
