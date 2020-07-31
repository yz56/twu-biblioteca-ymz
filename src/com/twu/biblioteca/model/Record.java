package com.twu.biblioteca.model;

public class Record {
    private String user;
    private int bookId;

    public Record(String user, int bookId) {
        this.user = user;
        this.bookId = bookId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getBook() {
        return bookId;
    }

    public void setBook(int id) {
        this.bookId = id;
    }
}
