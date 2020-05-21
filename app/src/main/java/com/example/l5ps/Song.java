package com.example.l5ps;

import java.io.Serializable;

public class Song implements Serializable {
    int id, year, stars;
    String title,singers;

    public Song( int year, int stars, String title, String singers) {

        this.year = year;
        this.stars = stars;
        this.title = title;
        this.singers = singers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSingers() {
        return singers;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }
}
