package lv.javaguru.java2.cakeConstructor.newApp;

import lv.javaguru.java2.cakeConstructor.newApp.console_ui.*;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.*;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.*;

import java.util.Scanner;

public class Application {

    private static Database database = new InMemoryDatabaseImpl();

    private static AddIngredientRequestValidator addIngredientRequestValidator = new AddIngredientRequestValidator();
    private static RemoveIngredientRequestValidator removeIngredientRequestValidator = new RemoveIngredientRequestValidator();

    private static SearchIngredientsRequestFieldValidator searchIngredientsRequestFieldValidator = new SearchIngredientsRequestFieldValidator();

    private static OrderingValidator orderingValidator = new OrderingValidator();
    private static PagingValidator pagingValidator = new PagingValidator();
    private static SearchIngredientsRequestValidator searchIngredientsRequestValidator = new SearchIngredientsRequestValidator(
            searchIngredientsRequestFieldValidator, orderingValidator, pagingValidator);

    private static AddIngredientService addIngredientService = new AddIngredientService(database,addIngredientRequestValidator);
    private static RemoveIngredientService removeIngredientService = new RemoveIngredientService(database, removeIngredientRequestValidator);
    private static GetAllIngredientsService getAllIngredientsService = new GetAllIngredientsService(database);
    private static SearchIngredientsService searchIngredientsService = new SearchIngredientsService(database,searchIngredientsRequestValidator);

    private static UIAction addIngredientUIAction = new AddIngredientUIAction(addIngredientService);
    private static UIAction removeIngredientUIAction = new RemoveIngredientUIAction(removeIngredientService);
    private static UIAction getAllIngredientsUIAction = new GetAllIngredientsUIAction(getAllIngredientsService);
    private static UIAction searchIngredientsUIAction = new SearchIngredientsUIAction(searchIngredientsService);

    private static UIAction exitUIAction = new ExitUIAction();


    public static void main(String[] args) {

        while (true){
            printProgramMenu();
            int userChoice = getUserChoice();
            executeSelectedMenuItem(userChoice);

        }
    }

    private static void printProgramMenu(){
        System.out.println("Program menu:");
        System.out.println("1. Add ingredient to cake");
        System.out.println("2. Delete ingredient from cake");
        System.out.println("3. Show all ingredients in the cake");
        System.out.println("4. Search ingredients");
        System.out.println("5. Exit");

        System.out.println("");
    }

    private static int getUserChoice(){
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void executeSelectedMenuItem(int selectedMenu) {
        switch (selectedMenu) {
            case 1: {
                addIngredientUIAction.execute();
                break;
            }
            case 2: {
                removeIngredientUIAction.execute();
                break;
            }
            case 3: {
                getAllIngredientsUIAction.execute();
                break;
            }
            case 4: {
                searchIngredientsUIAction.execute();
            }
            case 5: {
                exitUIAction.execute();
                break;
            }
        }
    }
}
