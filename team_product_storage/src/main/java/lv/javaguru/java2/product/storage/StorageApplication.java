package lv.javaguru.java2.product.storage;

import lv.javaguru.java2.product.storage.console_ui.AddProductUIAction;
import lv.javaguru.java2.product.storage.console_ui.ExitProgramUIAction;
import lv.javaguru.java2.product.storage.console_ui.PrintAllProductsUIAction;
import lv.javaguru.java2.product.storage.console_ui.RemoveProductUIAction;
import lv.javaguru.java2.product.storage.console_ui.SearchProductsUIAction;

import java.util.Scanner;

public class StorageApplication {

    private static ApplicationContext applicationContext = new ApplicationContext();

    public static void main(String[] args) {
            while (true) {
            printMenu();
            int userChoice = getUserMenuChoice();
            executeMenu(userChoice);
        }
    }

    private static void printMenu() {
        System.out.println("Menu: ");
        System.out.println("Press 1: Add product to list: ");
        System.out.println("Press 2: Remove product from list: ");
        System.out.println("Press 3: Display all products in the list: ");
        System.out.println("Press 4. Search products");
        System.out.println("Press 5: Exit from program.");

        System.out.println("");
    }

    private static int getUserMenuChoice() {
        System.out.println("Enter menu item number to execute ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void executeMenu(int userChoice) {
        switch (userChoice) {
            case 1: {
                AddProductUIAction uiAction = applicationContext.getBean(AddProductUIAction.class);
                uiAction.execute();
                break;
            }
            case 2: {
                RemoveProductUIAction uiAction = applicationContext.getBean(RemoveProductUIAction.class);
                uiAction.execute();
                break;
            }
            case 3: {
                PrintAllProductsUIAction uiAction = applicationContext.getBean(PrintAllProductsUIAction.class);
                uiAction.execute();
                break;
            }
            case 4: {
                SearchProductsUIAction uiAction = applicationContext.getBean(SearchProductsUIAction.class);
                uiAction.execute();
                break;
            }
            case 5: {
                ExitProgramUIAction uiAction = applicationContext.getBean(ExitProgramUIAction.class);
                uiAction.execute();
                break;
            }
        }
    }

}
