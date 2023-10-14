package lv.javaguru.travel.insurance;

import lv.javaguru.travel.insurance.database.Database;
import lv.javaguru.travel.insurance.database.InMemoryDatabase;
import lv.javaguru.travel.insurance.services.AddBookService;
import lv.javaguru.travel.insurance.services.DeleteBookService;
import lv.javaguru.travel.insurance.services.GetAllBooksService;
import lv.javaguru.travel.insurance.ui.AddBookUIAction;
import lv.javaguru.travel.insurance.ui.DeleteBookUIAction;
import lv.javaguru.travel.insurance.ui.PrintAllBooksUIAction;
import lv.javaguru.travel.insurance.ui.ProgramExitUIAction;

import java.util.Scanner;

public class BookListApplication {

    public static void main(String[] args) {

    Database database = new InMemoryDatabase();

    AddBookService addBookService = new AddBookService(database);
    DeleteBookService deleteBookService = new DeleteBookService(database);
    GetAllBooksService getAllBooksService = new GetAllBooksService(database);

    AddBookUIAction addBookUIAction = new AddBookUIAction(addBookService);
    DeleteBookUIAction deleteBookUIAction = new DeleteBookUIAction(deleteBookService);
    PrintAllBooksUIAction printAllBooksUIAction = new PrintAllBooksUIAction(getAllBooksService);
    ProgramExitUIAction programExitUIAction = new ProgramExitUIAction();

    while (true) {
        printMenu();
        int userChoice = getUserMenuChoice();
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
