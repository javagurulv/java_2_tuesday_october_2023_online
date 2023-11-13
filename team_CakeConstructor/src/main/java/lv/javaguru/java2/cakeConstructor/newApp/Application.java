package lv.javaguru.java2.cakeConstructor.newApp;

import lv.javaguru.java2.cakeConstructor.newApp.console_ui.*;
import lv.javaguru.java2.cakeConstructor.newApp.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.database.DatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.database.Ingridient;
import lv.javaguru.java2.cakeConstructor.newApp.services.AddIngridientService;
import lv.javaguru.java2.cakeConstructor.newApp.services.GetAllIngridientsService;
import lv.javaguru.java2.cakeConstructor.newApp.services.RemoveIngridientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static DatabaseImpl database = new Database();

    private static AddIngridientService addService = new AddIngridientService(database);
    private static UIAction addIngridient = new AddIngridientUIAction(addService);

    private static RemoveIngridientService removeService = new RemoveIngridientService(database);
    private static UIAction remove = new RemoveIngridientUIAction(removeService);

    private static GetAllIngridientsService getAllService = new GetAllIngridientsService(database);
    private static UIAction getAllInfridients = new GetAllIngridientsUIAction(getAllService);

    private static UIAction exit = new ExitUIAction();


    public static void main(String[] args) {
        List<Ingridient> ingridients = new ArrayList<>();

        while (true){
            printProgramMenu();
            int userChoice = getUserChoice();
            executeSelectedMenuItem(userChoice);

        }
    }






    private static void printProgramMenu(){
        System.out.println("Program menu:");
        System.out.println("1. Add ingridient to cake");
        System.out.println("2. Delete ingridient from cake");
        System.out.println("3. Show all ingridients in the cake");
        System.out.println("4. Exit");

        System.out.println("");
    }

    private static int getUserChoice(){
        Scanner scan = new Scanner(System.in);
        int userChoice = scan.nextInt();
        return userChoice;
    }
    private static void executeSelectedMenuItem(int selectedMenu) {
        switch (selectedMenu) {
            case 1: {
                addIngridient.execute();
                break;
            }
            case 2: {
                remove.execute();
                break;
            }
            case 3: {
                getAllInfridients.execute();
                break;
            }
            case 4: {
                exit.execute();
                break;
            }
        }
    }
}
