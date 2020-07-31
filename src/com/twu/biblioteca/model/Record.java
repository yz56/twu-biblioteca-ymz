package com.twu.biblioteca.model;

public class Record {
    private String user;
    private String book;

    public Record(String user, String book) {
        this.user = user;
        this.book = book;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
