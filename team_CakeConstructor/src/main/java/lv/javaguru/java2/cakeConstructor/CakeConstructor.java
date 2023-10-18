package lv.javaguru.java2.cakeConstructor;

import lv.javaguru.java2.cakeConstructor.consoole_ui.AddCakeUIAction;
import lv.javaguru.java2.cakeConstructor.consoole_ui.ExitUIAction;
import lv.javaguru.java2.cakeConstructor.consoole_ui.GetAllCakesForClientUIAction;
import lv.javaguru.java2.cakeConstructor.consoole_ui.UIAction;
import lv.javaguru.java2.cakeConstructor.core.database.DataBase;
import lv.javaguru.java2.cakeConstructor.core.database.DateBaseIf;
import lv.javaguru.java2.cakeConstructor.services.AddCakeService;
import lv.javaguru.java2.cakeConstructor.services.GetCakesForClientService;

import java.util.Scanner;

public class CakeConstructor {

    private static DataBase dataBase = new DataBase();
    private static AddCakeService addCakeService = new AddCakeService(dataBase);
    private static GetCakesForClientService getCakesForClientService = new GetCakesForClientService(dataBase);
    private static UIAction addCake = new AddCakeUIAction(addCakeService);
    private static UIAction getCakeForClient = new GetAllCakesForClientUIAction(getCakesForClientService);
    private static UIAction exit = new ExitUIAction();


    public static void main(String[] args) {

        while (true) {
            printMenu();
            int getUserMenuChoice = getUserMenuChoice();
            executeSelectedMenuItem(dataBase, getUserMenuChoice);
        }
    }

    public static void printMenu(){
        System.out.println("Welcome to cake constructor!");
        System.out.println("Press 1 - create a cake");
        System.out.println("Press 2 - check order ");
        System.out.println("Press 3 - exit");
    }

    public static int getUserMenuChoice(){
        Scanner scan = new Scanner(System.in);
        int userChoice = scan.nextInt();
        return userChoice;
    }

    public static void executeSelectedMenuItem(DateBaseIf dataBase, int getUSerMenuChoice) {

        switch (getUSerMenuChoice) {
            case 1: {
                addCake.execute();
                break;
            }

            case 2: {
                getCakeForClient.execute();
                break;
            }
            case 3: {
                exit.execute();
            }
        }
    }
}
