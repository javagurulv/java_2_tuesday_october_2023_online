package lv.javaguru.java2.lessoncode.bookapp;

import lv.javaguru.java2.lessoncode.bookapp.console_ui.*;
import lv.javaguru.java2.lessoncode.bookapp.core.database.Database;
import lv.javaguru.java2.lessoncode.bookapp.core.database.InMemoryDatabase;
import lv.javaguru.java2.lessoncode.bookapp.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.bookapp.core.services.SearchBooksService;
import lv.javaguru.java2.lessoncode.bookapp.core.services.AddBookRequestValidator;
import lv.javaguru.java2.lessoncode.bookapp.core.services.SearchBooksRequestValidator;
import lv.javaguru.java2.lessoncode.bookapp.core.services.DeleteBookService;
import lv.javaguru.java2.lessoncode.bookapp.core.services.GetAllBooksService;

import java.util.Scanner;

    public class BookListApplication {

    private static Database database = new InMemoryDatabase();

    private static AddBookRequestValidator addBookRequestvalidator = new AddBookRequestValidator(database);

    private static SearchBooksRequestValidator searchBooksRequestValidator = new SearchBooksRequestValidator();
    private static AddBookService addBookService = new AddBookService(database, addBookRequestvalidator);
    private static DeleteBookService deleteBookService = new DeleteBookService(database);
    private static GetAllBooksService getAllBooksService = new GetAllBooksService(database);
    private static SearchBooksService searchBooksService = new SearchBooksService(database, searchBooksRequestValidator);

    private static AddBookUIAction addBookUIAction = new AddBookUIAction(addBookService);
    private static DeleteBookUIAction deleteBookUIAction = new DeleteBookUIAction(deleteBookService);
    private static PrintAllBooksUIAction printAllBooksUIAction = new PrintAllBooksUIAction(getAllBooksService);
    private static ProgramExitUIAction programExitUIAction = new ProgramExitUIAction();
    private static SearchBooksUIAction searchBooksUIAction = new SearchBooksUIAction(searchBooksService);

    public static void main(String[] args) {
    while (true) {
        printMenu();
        int userChoice = getUserMenuChoice();

        executeSelectedMenuItem(userChoice);
    }
}

    private static void executeSelectedMenuItem(int userChoice) {
        switch(userChoice) {
            case 1: {
                addBookUIAction.execute();
                break;
            }
            case 2: {
                deleteBookUIAction.execute();
                break;
            }
            case 3: {
                printAllBooksUIAction.execute();
                break;
            }
            case 4: {
                searchBooksUIAction.execute();
                break;
            }
            case 5: {
                programExitUIAction.execute();

            }
        }
    }

    private static int getUserMenuChoice() {
            System.out.println("Enter menu item number to execute ");
            Scanner scanner = new Scanner(System.in);
            return Integer.parseInt(scanner.nextLine());
        }

        private static void printMenu() {
            System.out.println("Program menu: ");
            System.out.println("1. Add book to list: ");
            System.out.println("2. Delete book from list: ");
            System.out.println("3. Show all books in the list: ");
            System.out.println("4. Search books");
            System.out.println("5. Exit");

            System.out.println("");
        }
}
