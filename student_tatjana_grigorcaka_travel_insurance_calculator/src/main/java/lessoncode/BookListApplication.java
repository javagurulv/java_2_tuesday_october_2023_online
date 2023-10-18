package lessoncode;

import lessoncode.database.Database;
import lessoncode.database.InMemoryDatabase;
import lessoncode.services.AddBookService;
import lessoncode.services.DeleteBookService;
import lessoncode.services.GetAllBooksService;
import lessoncode.ui.AddBookUIAction;
import lessoncode.ui.DeleteBookUIAction;
import lessoncode.ui.PrintAllBooksUIAction;
import lessoncode.ui.ProgramExitUIAction;

import java.util.Scanner;

public class BookListApplication {

    static Database database = new InMemoryDatabase();

    private static AddBookRequestValidator validator = new AddBookRequestValidator(database);

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

        executeSelectedMenuItime(userChoice);
    }
}

    private static void executeSelectedMenuItime(int userChoice) {
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
