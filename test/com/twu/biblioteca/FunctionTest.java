package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.BibliotecaApp.*;
import static org.junit.Assert.assertEquals;

public class FunctionTest {
    BibliotecaApp app = new BibliotecaApp();

    @Test
    public void welcomeTest() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);
    }
    @Test
    public void viewBookListTest() {
        assertEquals(staticBooks, app.getAllBooks());
    }
    @Test
    public void choiceMenuTest() {
        List<Book> books = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();
        assertEquals(false, app.choiceMenu("1",books, movies));
        assertEquals(false, app.choiceMenu("2",books, movies));
        assertEquals(false, app.choiceMenu("3",books, movies));
        assertEquals(true, app.choiceMenu("5",books, movies));
    }
    @Test
    public void checkoutTest() {
        Book book0 = new Book(0,"book0","Tony",1993, true);
        Book book1 = new Book(1,"book1","Jenny",1991, false);

        assertEquals(true,  app.checkoutBook(book0));
        assertEquals(false, app.checkoutBook(book1));
    }
    @Test
    public void returnBookTest() {
        assertEquals(0, app.findBookByName("book0", staticBooks));
        assertEquals(1, app.findBookByName("book1", staticBooks));
        assertEquals(2, app.findBookByName("book2", staticBooks));
        assertEquals(-1, app.findBookByName("invalid name", staticBooks));
        assertEquals(-1, app.findBookByName("", staticBooks));
        assertEquals(-1, app.findBookByName(null, staticBooks));
    }
    @Test
    public void viewMovieListTest() {
        assertEquals(staticMovies, app.getAllMovies());
    }
    @Test
    public void checkUserTest() {
        assertEquals(true, app.checkUser("111-1111","1"));
        assertEquals(true, app.checkUser("222-2222","2"));
        assertEquals(false, app.checkUser("invalidUsername","1"));
        assertEquals(false, app.checkUser("111-1111","wrongPassword"));
    }
    @Test
    public void removeBookTest(){
        assertEquals(false, app.removeRecord("111-1111",3));
        assertEquals(false, app.removeRecord("222-2222",1));
        assertEquals(true, app.removeRecord("222-2222",3));
    }
}
