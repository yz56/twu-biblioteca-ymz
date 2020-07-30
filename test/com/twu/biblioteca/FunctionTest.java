package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
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
        assertEquals(false, app.choiceMenu("1",books));
        assertEquals(false, app.choiceMenu("2",books));
        assertEquals(true, app.choiceMenu("3",books));
    }
    @Test
    public void checkoutTest() {
        Book book0 = new Book(0,"book0","Tony",1993, true);
        Book book1 = new Book(1,"book1","Jenny",1991, false);

        assertEquals(true, app.checkoutBook(book0));
        assertEquals(false, app.checkoutBook(book1));
    }
    @Test
    public void returnBookTest() {
        assertEquals(true, app.findBookByName("book0", staticBooks));
        assertEquals(true, app.findBookByName("book1", staticBooks));
        assertEquals(true, app.findBookByName("book2", staticBooks));
        assertEquals(false, app.findBookByName("invalid name", staticBooks));
        assertEquals(false, app.findBookByName("", staticBooks));
        assertEquals(false, app.findBookByName(null, staticBooks));
    }

}
