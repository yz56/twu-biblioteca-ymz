package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    public static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static List<Book> staticBooks = new ArrayList<Book>();
    static Book book0 = new Book(0,"book0","Tony",1993, true);
    static Book book1 = new Book(1,"book1","Jenny",1991, false);
    static Book book2 = new Book(2,"book2","Jim",2020, true);
    static{
        staticBooks.add(book0);
        staticBooks.add(book1);
        staticBooks.add(book2);
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        boolean quit = false;
        while(!quit){
            quit = app.displayMenu();
        }
    }

    public boolean displayMenu(){
        List<Book> books = this.getAllBooks();
        System.out.println("\n" + welcomeMessage);
        System.out.println("1. View list of all books");
        System.out.println("2. Return books");
        System.out.println("3. Quit");
        System.out.println("Please input num of options(1 - 3)");
        Scanner s = new Scanner(System.in);
        String choice = s.next();
        return choiceMenu(choice, books);
    }

    public List<Book> getAllBooks() {
        return staticBooks;
    }

    public boolean choiceMenu(String choice, List<Book> books) {
        switch (choice){
            case "1":
                if(books.size()!=0)
                    viewBookList(books);
                break;
            case "2":
                if(books.size()!=0)
                    returnBook(books);
                break;
            case "3":
                System.out.println("Bye!");
                return true;
            default:
                System.out.println("Please select a valid option!");
                break;
        }
        return false;
    }

    public void viewBookList(List<Book> books) {
        while (true){
            System.out.println("\nWhich book you want？ Please input the number of book to see details");
            System.out.println("Book list:");
            for (Book book : books){
                System.out.print(book.getId()+ " - ");
                System.out.println(book.getName());
            }
            int num;
            try{
                Scanner s = new Scanner(System.in);
                num = s.nextInt();
                detailOfBook(books.get(num));
            }catch (Exception e){
                System.out.println("Input error.Please input number in the list.");
                continue;
            }
            while(true) {
                System.out.println("Would you want to borrow this book?");
                System.out.println("Press y/Y(Yes) | n/N (No) to continue.");
                Scanner s = new Scanner(System.in);
                String input = s.next();
                if (input.equals("y") || input.equals("Y")) {
                    if (checkoutBook(books.get(num))) {
                        System.out.println("Thank you! Enjoy the book.");
                    } else {
                        System.out.println("Sorry, that book is not available.");
                    }
                    return ;
                } else if (input.equals("n") || input.equals("N")) {
                    return ;
                } else {
                    System.out.println("Input error! ");
                }
            }
        }
    }

    private static void detailOfBook(Book book) {
        System.out.println("Detail of this book:");
        System.out.println("Name: " + book.getName());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Publish Year: " + book.getPublishYear());
    }

    public boolean checkoutBook(Book book) {
        return book.getIsValid();
    }

    public void returnBook(List<Book> books) {
        System.out.print("Please input the name of book you want to return.: ");
        Scanner s = new Scanner(System.in);
        String bookName = s.next();

        if(findBookByName(bookName, books)){
            System.out.println("Thank you for returning the book.");
        }else{
            System.out.println("That is not a valid book to return.");
        }

    }

    public boolean findBookByName(String bookName, List<Book> books) {
        if(bookName == null) return false;
        boolean res = false;
        for (Book book : books){
            if(bookName.equals(book.getName()))
                res = true;
        }
        return res;
    }
}
