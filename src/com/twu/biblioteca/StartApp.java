package com.twu.biblioteca;

public class StartApp {
    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        boolean quit = false;
        while (!quit) {
            quit = app.displayMenu();
        }
    }
}
