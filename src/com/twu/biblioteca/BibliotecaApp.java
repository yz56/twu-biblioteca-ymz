package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Record;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    public static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static List<Book> staticBooks = new ArrayList<Book>();
    public static List<Movie> staticMovies = new ArrayList<Movie>();
    public static List<User> userList = new ArrayList<User>();
    public static List<Record> recordList = new ArrayList<Record>();
    static {
        Book book0 = new Book(0, "book0", "Tony", 1993, true);
        Book book1 = new Book(1, "book1", "Jenny", 1991, true);
        Book book2 = new Book(2, "book2", "Jim", 2020, true);
        Book book3 = new Book(3, "book3", "Bob", 1888, false);
        staticBooks.add(book0);
        staticBooks.add(book1);
        staticBooks.add(book2);
        staticBooks.add(book3);
        recordList.add(new Record("222-2222", 3));
        Movie movie0 = new Movie(0, "The Shawshank Redemption", "Frank Darabont", 1994, 8);
        Movie movie1 = new Movie(1, "Forrest Gump", " Robert Zemeckis", 1994, 6);
        Movie movie2 = new Movie(2, "Memento", " Christopher Nolan", 2020, 10);
        staticMovies.add(movie0);
        staticMovies.add(movie1);
        staticMovies.add(movie2);
        User user0 = new User(0,"111-1111","1","xiaohua123@gmail.com","13349392048");
        User user1 = new User(0,"222-2222","2","xiaogou124@gmail.com","13549392047");
        User admin = new User(0,"admin","admin","admin123@gmail.com","13549392222");
        userList.add(user0);
        userList.add(user1);
        userList.add(admin);
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        boolean quit = false;
        while (!quit) {
            quit = app.displayMenu();
        }
    }

    public boolean displayMenu() {
        List<Book> books = this.getAllBooks();
        List<Movie> movies = this.getAllMovies();
        System.out.println("\n" + welcomeMessage);
        System.out.println("1. View list of all books(userLogin required)");
        System.out.println("2. Return books(userLogin required)");
        System.out.println("3. View list of all movies");
        System.out.println("4. View my information");
        System.out.println("5. Library admin userLogin");
        System.out.println("6. Quit");
        System.out.println("Please input num of options(1 - 4)");
        Scanner s = new Scanner(System.in);
        String choice = s.next();
        return choiceMenu(choice, books, movies);
    }

    public List<Book> getAllBooks() {
        return staticBooks;
    }

    public boolean choiceMenu(String choice, List<Book> books, List<Movie> movies) {
        switch (choice) {
            case "1":
                if (books.size() != 0)
                    viewBookList(books);
                break;
            case "2":
                if (books.size() != 0)
                    returnBook(books);
                break;
            case "3":
                if (movies.size() != 0)
                    viewMovieList(movies);
                break;
            case "4":
                    userLogin();
                break;
            case "5":
                    adminLogin();
                break;
            case "6":
                System.out.println("Bye!");
                return true;
            default:
                System.out.println("Please select a valid option!");
                break;
        }
        return false;
    }

    public void viewBookList(List<Book> books) {
        while (true) {
            System.out.println("\nWhich book you want？ Please input the number of book to see details");
            System.out.println("Book list:");
            for (Book book : books) {
                if (book.getIsValid()) {
                    System.out.print(book.getId() + " - ");
                    System.out.println(book.getName());
                }
            }
            int id;
            try {
                Scanner s = new Scanner(System.in);
                id = s.nextInt();
                if (books.get(id).getIsValid()) {
                    detailOfBook(books.get(id));
                    while (true) {
                        System.out.println("Would you want to borrow this book?");
                        System.out.println("Press y/Y(Yes) | n/N (No) to continue.");
                        s = new Scanner(System.in);
                        String input = s.next();
                        if (input.equals("y") || input.equals("Y")) {
                            String[] user_password = inputUserInfo();
                            boolean res = checkUser(user_password[0], user_password[1]);
                            if(res){
                                if (checkoutBook(books.get(id))) {
                                    staticBooks.get(id).setValid(false);
                                    insertRecord(user_password[0], id);
                                    System.out.println("Thank you! Enjoy the book.");
                                } else {
                                    System.out.println("Sorry, that book is not available.");
                                }
                            }else{
                                System.out.println("Sorry, username or password input error.");
                            }
                            return;
                        } else if (input.equals("n") || input.equals("N")) {
                            return;
                        } else {
                            System.out.println("Input error! ");
                        }
                    }
                } else {
                    System.out.println("Sorry, that book is not available.");
                }
            } catch (Exception e) {
                System.out.println("Input error.Please input number in the list.");
                continue;
            }
        }
    }

    public boolean checkUser(String username, String password) {
        for(User u : userList){
            if(username.equals(u.getName())){
                if(password.equals(u.getPassword())){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    public void insertRecord(String username, int id){
        recordList.add(new Record(username, id));
    }

    public boolean removeRecord(String username, int id){
        for (Record r : recordList){
            if(username.equals(r.getUser()) || id == r.getBook()){
                recordList.remove(r);
                return true;
            }
        }
        return false;
    }
    public String[] inputUserInfo(){
        String[] res = new String[2];
        Scanner s = new Scanner(System.in);
        System.out.print("Please input username:");
        res[0] = s.next();
        System.out.print("Please input password:");
        res[1] = s.next();
        return res;
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
        String[] user_password = inputUserInfo();
        boolean res = checkUser(user_password[0], user_password[1]);
        if(res){
            System.out.print("Please input the name of book you want to return.: ");
            Scanner s = new Scanner(System.in);
            String bookName = s.next();
            int id = findBookByName(bookName, books);
            if (id != -1) {
                staticBooks.get(id).setValid(true);
                if(removeRecord(user_password[0], id))
                    System.out.println("Thank you for returning the book.");
                else
                    System.out.println("Return book fail.Please check book'name.");
            } else {
                System.out.println("That is not a valid book to return.");
            }
        }else{
            System.out.println("Sorry, username or password input error.");
        }
    }

    public int findBookByName(String bookName, List<Book> books) {
        if (bookName == null) return -1;
        for (Book book : books) {
            if (bookName.equals(book.getName()))
                return book.getId();
        }
        return -1;
    }

    public List<Movie> getAllMovies() {
        return staticMovies;
    }
    public void viewMovieList(List<Movie> movies) {
        while (true) {
            System.out.println("\nWhich movie you want？ Please input the number of movie to see details");
            System.out.println("Movie list:");
            for (Movie movie : movies) {
                    System.out.print(movie.getId() + " - ");
                    System.out.println(movie.getName());
            }
            int id;
            try {
                Scanner s = new Scanner(System.in);
                id = s.nextInt();
                if (id < movies.size()) {
                    detailOfMovie(movies.get(id));
                    while (true) {
                        System.out.println("Would you want to watch this movie?");
                        System.out.println("Press y/Y(Yes) | n/N (No) to continue.");
                        s = new Scanner(System.in);
                        String input = s.next();
                        if (input.equals("y") || input.equals("Y")) {
                            System.out.println("Thank you! Enjoy the movie.\n");
                            System.out.println("Press q or Q to return main menu.");
                            s = new Scanner(System.in);

                            while(s.hasNextLine()){
                                String in = s.next();
                                if(in.equals("q") || in.equals("Q"))
                                    return;
                            }
                        } else if (input.equals("n") || input.equals("N")) {
                            return;
                        } else {
                            System.out.println("Input error! ");
                        }
                    }
                } else {
                    System.out.println("Sorry, that movie is not available.");
                }
            } catch (Exception e) {
                System.out.println("Input error.Please input number in the list.");
                continue;
            }
        }
    }
    private static void detailOfMovie(Movie movie) {
        System.out.println("Detail of this book:");
        System.out.println("Name: " + movie.getName());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Year: " + movie.getYear());
        System.out.print("Rating: ");
        for (int i = 0; i < movie.getRating(); i++) {
            System.out.print("★");
        }
        System.out.println();
    }
    public void userLogin() {
        String[] user_password = inputUserInfo();
        boolean res = checkUser(user_password[0], user_password[1]);
        if(res){
            User user = findUser(user_password[0]);
            System.out.println("\nPersonal Information:");
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Phone: " + user.getPhone());
        }else{
            System.out.println("Sorry, username or password error.");
        }
    }
    public void adminLogin() {
        String[] user_password = inputUserInfo();
        if(user_password[0].equals("admin") && user_password[1].equals("admin")){
            displayRecord();
        }else {
            System.out.println("Sorry, username or password error.");
        }
    }

    public void displayRecord() {
        System.out.println("User  Id -\tBook");
        for (Record r : recordList) {
            System.out.println(r.getUser() +" -\t" + staticBooks.get(r.getBook()).getName());
        }
    }

    public User findUser(String s) {
        for (User user : userList){
            if(s.equals(user.getName()))
                return user;
        }
        return null;
    }
}
