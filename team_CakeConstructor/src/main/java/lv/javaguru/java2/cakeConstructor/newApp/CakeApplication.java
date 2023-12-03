package lv.javaguru.java2.cakeConstructor.newApp;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lv.javaguru.java2.cakeConstructor.newApp.config.CakeConfiguration;
import lv.javaguru.java2.cakeConstructor.newApp.console_ui.*;


public class CakeApplication {

    private static ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(CakeConfiguration.class);

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
                AddIngredientUIAction uiAction = applicationContext.getBean(AddIngredientUIAction.class);
                uiAction.execute();
                break;
            }
            case 2: {
                RemoveIngredientUIAction uiAction = applicationContext.getBean(RemoveIngredientUIAction.class);
                uiAction.execute();
                break;
            }
            case 3: {
                GetAllIngredientsUIAction uiAction = applicationContext.getBean(GetAllIngredientsUIAction.class);
                uiAction.execute();
                break;
            }
            case 4: {
                SearchIngredientsUIAction uiAction = applicationContext.getBean(SearchIngredientsUIAction.class);
                uiAction.execute();
                break;
            }
            case 5: {
                ExitUIAction uiAction = applicationContext.getBean(ExitUIAction.class);
                uiAction.execute();
                break;
            }
        }
    }
}
