package lv.javaguru.java2.lessoncode.bookapp;

import lv.javaguru.java2.lessoncode.bookapp.core.database.Database;
import lv.javaguru.java2.lessoncode.bookapp.core.database.InMemoryDatabase;
import lv.javaguru.java2.lessoncode.bookapp.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.bookapp.core.services.AddBookValidator;
import lv.javaguru.java2.lessoncode.bookapp.core.services.DeleteBookService;
import lv.javaguru.java2.lessoncode.bookapp.core.services.GetAllBooksService;
import lv.javaguru.java2.lessoncode.bookapp.console_ui.AddBookUIAction;
import lv.javaguru.java2.lessoncode.bookapp.console_ui.DeleteBookUIAction;
import lv.javaguru.java2.lessoncode.bookapp.console_ui.PrintAllBooksUIAction;
import lv.javaguru.java2.lessoncode.bookapp.console_ui.ProgramExitUIAction;

import java.util.Scanner;

    public class BookListApplication {

    static Database database = new InMemoryDatabase();

    private static AddBookValidator validator = new AddBookValidator(database);
    static AddBookService addBookService = new AddBookService(database, validator);
    static DeleteBookService deleteBookService = new DeleteBookService(database);
    static GetAllBooksService getAllBooksService = new GetAllBooksService(database);

    static AddBookUIAction addBookUIAction = new AddBookUIAction(addBookService);
    static DeleteBookUIAction deleteBookUIAction = new DeleteBookUIAction(deleteBookService);
    static PrintAllBooksUIAction printAllBooksUIAction = new PrintAllBooksUIAction(getAllBooksService);
    static ProgramExitUIAction programExitUIAction = new ProgramExitUIAction();

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
            System.out.println("Add book to list: ");
            System.out.println("Delete book from list: ");
            System.out.println("Show all books in the list: ");
            System.out.println("Exit");

            System.out.println("");
        }
}
