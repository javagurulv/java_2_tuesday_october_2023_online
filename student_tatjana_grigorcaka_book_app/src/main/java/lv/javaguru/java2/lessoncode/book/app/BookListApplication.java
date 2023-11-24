package lv.javaguru.java2.lessoncode.book.app;

import lv.javaguru.java2.lessoncode.book.app.console_ui.AddBookUIAction;
import lv.javaguru.java2.lessoncode.book.app.console_ui.ProgramExitUIAction;
import lv.javaguru.java2.lessoncode.book.app.console_ui.PrintAllBooksUIAction;
import lv.javaguru.java2.lessoncode.book.app.console_ui.RemoveBookUIAction;
import lv.javaguru.java2.lessoncode.book.app.console_ui.SearchBooksUIAction;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.ApplicationContext;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIApplicationContextBuilder;

import java.util.Scanner;

    public class BookListApplication {

        private static ApplicationContext applicationContext =
                new DIApplicationContextBuilder().build("lv.javaguru.java2.lessoncode.book.app");

    public static void main(String[] args) {
    while (true) {
        printMenu();
        int userChoice = getUserMenuChoice();

        executeSelectedMenuItem(userChoice);
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
            System.out.println("5. Exit program");

            System.out.println("");
        }

        private static void executeSelectedMenuItem(int userChoice) {
            switch(userChoice) {
                case 1: {
                    AddBookUIAction uiAction = applicationContext.getBean(AddBookUIAction.class);
                    uiAction.execute();
                    break;
                }
                case 2: {
                    RemoveBookUIAction uiAction = applicationContext.getBean(RemoveBookUIAction.class);
                    uiAction.execute();
                    break;
                }
                case 3: {
                    PrintAllBooksUIAction uiAction = applicationContext.getBean(PrintAllBooksUIAction.class);
                    uiAction.execute();
                    break;
                }
                case 4: {
                    SearchBooksUIAction uiAction = applicationContext.getBean(SearchBooksUIAction.class);
                    uiAction.execute();
                    break;
                }
                case 5: {
                    ProgramExitUIAction uiAction = applicationContext.getBean(ProgramExitUIAction.class);
                    uiAction.execute();
                    break;
                }
            }
        }
}
