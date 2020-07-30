package com.twu.biblioteca.model;

public class Book {
    private int id;
    private String name;
    private String author;
    private int publishYear;
    private boolean isValid;

    public Book(int id, String name, String author, int publishYear, boolean isValid) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.isValid = isValid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }

    public int getId() {
        return this.id;
    }
    public boolean getIsValid() {
        return this.isValid;
    }
}
