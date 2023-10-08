package lv.javaguru.travel.insurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookListApplication {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("Program menu: ");
            System.out.println("Add book to list: ");
            System.out.println("Delete book from list: ");
            System.out.println("Show all books in the list: ");
            System.out.println("Exit");

            System.out.println("");

            System.out.println("Enter menu item number to execute ");
            Scanner scanner = new Scanner(System.in);
            int userChoice = Integer.parseInt(scanner.nextLine());

            switch(userChoice) {
                case 1: {
                    System.out.println("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String bookAuthor = scanner.nextLine();
                    Book book = new Book(bookTitle, bookAuthor);
                    books.add(book);
                    System.out.println("Your book was added to the list: ");
                    break;
                }
                case 2: {
                    System.out.println("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String bookAuthor = scanner.nextLine();
                    Book book = new Book(bookTitle, bookAuthor);
                    books.remove(book);
                    System.out.println("Your book was deleted from the list: ");
                    break;
                }
                case 3: {
                    System.out.println("Book list: ");
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    System.out.println("Book list end.");
                    break;
                }
                case 4: {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
            }
        }
    }
}
