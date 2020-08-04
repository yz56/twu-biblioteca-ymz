package com.twu.biblioteca;

public class StartApp {
    /*
    user1 info:   username:111-1111 password:1
    user2 info:   username:222-2222 password:2
    admin info:   username:admin password:admin

    At the beginning, book3 was borrowed by user2, so other books(book0~book2) are valid, book3 is invalid.
     */
    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        boolean quit = false;
        while (!quit) {
            quit = app.displayMenu();
        }
    }
}
