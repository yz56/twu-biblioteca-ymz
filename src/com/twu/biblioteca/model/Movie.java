package com.twu.biblioteca.model;

public class Movie {
    private int id;
    private String name;
    private String director;
    private int year;
    private int rating;
    private boolean isValid;

    public Movie(int id, String name, String director, int year, int rating, boolean isValid) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.isValid = isValid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public boolean getIsValid() {
        return this.isValid;
    }
}
