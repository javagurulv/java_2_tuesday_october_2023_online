package lv.javaguru.travel.insurance;

import java.util.Scanner;

public class BookListApplication {


    public static void main(String[] args) {

        Database database = new InMemoryDatabase();

        while (true) {
            printMenu();
            int userChoice = getUserMenuChoice();
            switch(userChoice) {
                case 1: {
                    addNewBookToList(database);
                    break;
                }
                case 2: {
                    deleteBookFromList(database);
                    break;
                }
                case 3: {
                    printBookList(database);
                    break;
                }
                case 4: {
                    exitFromProgram();
                }
            }
        }
    }

    private static int getUserMenuChoice() {
        System.out.println("Enter menu item number to execute ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
    private static void exitFromProgram() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    private static void printBookList(Database database) {
        System.out.println("Book list: ");
        for (Book book : database.getAllBooks()) {
            System.out.println(book);
        }
        System.out.println("Book list end.");
    }

    private static void deleteBookFromList(Database database) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author: ");
        String bookAuthor = scanner.nextLine();
        Book book = new Book(bookTitle, bookAuthor);
        database.deleteBook(book);
        System.out.println("Your book was deleted from the list: ");
    }

    private static void addNewBookToList(Database database) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author: ");
        String bookAuthor = scanner.nextLine();
        Book book = new Book(bookTitle, bookAuthor);
        database.addBook(book);
        System.out.println("Your book was added to the list: ");
    }

    private static void printMenu() {
        System.out.println("Program menu: ");
        System.out.println("Add book to list: ");
        System.out.println("Delete book from list: ");
        System.out.println("Show all books in the list: ");
        System.out.println("Exit");

        System.out.println("");
    }
}
