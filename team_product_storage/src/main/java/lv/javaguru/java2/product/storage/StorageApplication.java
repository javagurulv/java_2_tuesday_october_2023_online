package lv.javaguru.java2.product.storage;

import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.database.InMemoryDatabase;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.RemoveProductService;
import lv.javaguru.java2.product.storage.core.services.GetAllProductsService;
import lv.javaguru.java2.product.storage.ui.AddProductUIAction;
import lv.javaguru.java2.product.storage.ui.RemoveProductUIAction;
import lv.javaguru.java2.product.storage.ui.ExitProgramUIAction;
import lv.javaguru.java2.product.storage.ui.PrintAllProductsUIAction;

import java.util.Scanner;

public class StorageApplication {

    static Database database = new InMemoryDatabase();

    static AddProductService addProductService = new AddProductService(database);
    static RemoveProductService removeProductService = new RemoveProductService(database);
    static GetAllProductsService getAllProductService = new GetAllProductsService(database);

    static AddProductUIAction addProductUIAction = new AddProductUIAction(addProductService);
    static RemoveProductUIAction removeProductUIAction = new RemoveProductUIAction(removeProductService);
    static PrintAllProductsUIAction printAllProductsUIAction = new PrintAllProductsUIAction(getAllProductService);
    static ExitProgramUIAction exitProgramUIAction = new ExitProgramUIAction();

    public static void main(String[] args) {
            while (true) {
            printMenu();
            int userChoice = getUserMenuChoice();
            executeMenu(userChoice);
        }
    }

    private static void printMenu() {
        System.out.println("Menu: ");
        System.out.println("1.Add product to list: ");
        System.out.println("2.Remove product from list: ");
        System.out.println("3.Display all products in the list: ");
        System.out.println("4.Exit from program");

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
                addProductUIAction.execute();
                break;
            }
            case 2: {
                removeProductUIAction.execute();
                break;
            }
            case 3: {
                printAllProductsUIAction.execute();
                break;
            }
            case 4: {
                exitProgramUIAction.execute();
            }
        }
    }


}
