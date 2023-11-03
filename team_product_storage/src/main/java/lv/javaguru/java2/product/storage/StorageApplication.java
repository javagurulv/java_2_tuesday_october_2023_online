package lv.javaguru.java2.product.storage;

import lv.javaguru.java2.product.storage.console_ui.*;
import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.database.InMemoryDatabase;
import lv.javaguru.java2.product.storage.core.services.*;
import lv.javaguru.java2.product.storage.core.services.validators.AddProductRequestValidator;
import lv.javaguru.java2.product.storage.core.services.validators.RemoveProductRequestValidator;
import lv.javaguru.java2.product.storage.core.services.validators.SearchProductsRequestValidator;

import java.util.Scanner;

public class StorageApplication {

    private static Database database = new InMemoryDatabase();

    private static AddProductRequestValidator addProductRequestValidator = new AddProductRequestValidator();

    private static RemoveProductRequestValidator removeProductRequestValidator = new RemoveProductRequestValidator();

    private static SearchProductsRequestValidator searchProductsRequestValidator = new SearchProductsRequestValidator();
    private static AddProductService addProductService = new AddProductService(database, addProductRequestValidator);
    private static RemoveProductService removeProductService = new RemoveProductService(database, removeProductRequestValidator);
    private static GetAllProductsService getAllProductService = new GetAllProductsService(database);
    private static SearchProductsService searchProductsService = new SearchProductsService(database, searchProductsRequestValidator);

    private static UIAction addProductUIAction = new AddProductUIAction(addProductService);
    private static UIAction removeProductUIAction = new RemoveProductUIAction(removeProductService);
    private static UIAction printAllProductsUIAction = new PrintAllProductsUIAction(getAllProductService);
    private static UIAction exitProgramUIAction = new ExitProgramUIAction();
    private static UIAction searchProductsUIAction = new SearchProductsUIAction(searchProductsService);

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
        System.out.println("Press 4: Exit from program.");

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
                searchProductsUIAction.execute();
                break;
            }
            case 5: {
                exitProgramUIAction.execute();
            }
        }
    }


}
