
import consoole_ui.AddCakeUIAction;
import consoole_ui.ExitUIAction;
import consoole_ui.GetAllCakesForClientUIAction;
import consoole_ui.UIAction;
import database.DataBase;
import database.DateBaseIf;
import domain.Cake;
import domain.ListOfIngridients;

import java.util.List;
import java.util.Scanner;

public class CakeConstructor {

    private static DataBase dataBase = new DataBase();
    private static UIAction addCake = new AddCakeUIAction(dataBase);
    private static UIAction getCakeForClient = new GetAllCakesForClientUIAction(dataBase);
    private static UIAction exit = new ExitUIAction();


    public static void main(String[] args) {

        while (true) {
            printMenu();
            int getUserMenuChoice = getUserMenuChoice();
            executeSelectedMenuItem(dataBase, getUserMenuChoice);
        }
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
}
