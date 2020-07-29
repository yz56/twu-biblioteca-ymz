package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.BibliotecaApp.welcomeMessage;
import static org.junit.Assert.assertEquals;

public class WelcomeTest {

    @Test
    public void test() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);
    }
}
