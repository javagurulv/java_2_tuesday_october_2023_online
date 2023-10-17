package lv.simpleInventory;

import lv.simpleInventory.console_UI.*;
import lv.simpleInventory.database.Database;
import lv.simpleInventory.database.InMemoryDatabase;
import lv.simpleInventory.services.AddProductService;
import lv.simpleInventory.services.GetAllProductsService;
import lv.simpleInventory.services.RemoveProductsService;

import java.util.Scanner;

public class Inventory {

    private static Database database = new InMemoryDatabase();
    private static AddProductService addProductService = new AddProductService(database);

    private static GetAllProductsService getAllProductsService = new GetAllProductsService(database);

    private static RemoveProductsService removeProductsService = new RemoveProductsService(database);
    private static UIAction addProductAction = new AddProductsUIAction(addProductService);
    private static UIAction removeProductAction = new RemoveProductsUIAction(removeProductsService);
    private static UIAction getAllProductAction = new GetAllProductsUIAction(getAllProductsService);
    private static UIAction exitProductsAction = new ExitProductsUiAction();


    public static void main(String[] args) {
        while (true) {
            printMenu();
            int selectedNumber = usersChoice();
            executeMenu(selectedNumber);

        }

    }

    private static void executeMenu(int selectedNumber) {
        switch (selectedNumber) {
            case 1: {
                addProductAction.execute();
                break;
            }
            case 2: {
                removeProductAction.execute();
                break;
            }
            case 3: {
                getAllProductAction.execute();
                break;
            }
            case 4: {
                exitProductsAction.execute();
            }

        }
    }

    private static int usersChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String printMenu() {
        System.out.println("Inventory Menu");
        System.out.println("1.Add product");
        System.out.println("2.Remove product");
        System.out.println("3.View all products");
        System.out.println("4.Close application");
        System.out.println("");
        return null;
    }
}


