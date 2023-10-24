package lv.javaguru.java2.cakeConstructor;

import lv.javaguru.java2.cakeConstructor.consoole_ui.AddCakeUIAction;
import lv.javaguru.java2.cakeConstructor.consoole_ui.ExitUIAction;
import lv.javaguru.java2.cakeConstructor.consoole_ui.GetAllCakesForClientUIAction;
import lv.javaguru.java2.cakeConstructor.consoole_ui.UIAction;
import lv.javaguru.java2.cakeConstructor.core.cake.database.DataBase;
import lv.javaguru.java2.cakeConstructor.core.cake.database.DateBaseIf;
import lv.javaguru.java2.cakeConstructor.core.cake.database.InFileDateBAse;
import lv.javaguru.java2.cakeConstructor.core.cake.services.AddCakeService;
import lv.javaguru.java2.cakeConstructor.core.cake.services.AddCakeValidator;
import lv.javaguru.java2.cakeConstructor.core.cake.services.GetCakesForClientService;
import lv.javaguru.java2.cakeConstructor.core_user.SystemUserLogin;
import lv.javaguru.java2.cakeConstructor.core_user.UserLoginSystem;
import lv.javaguru.java2.cakeConstructor.core_user.user_domain.User;


import java.util.Scanner;

public class CakeConstructor {

    private static DateBaseIf dataBase = new DataBase();
    private static AddCakeValidator validator = new AddCakeValidator();
    private static AddCakeService addCakeService = new AddCakeService(dataBase,validator);
    private static GetCakesForClientService getCakesForClientService = new GetCakesForClientService(dataBase);
    private static UIAction addCake = new AddCakeUIAction(addCakeService);
    private static UIAction getCakeForClient = new GetAllCakesForClientUIAction(getCakesForClientService);
    private static UIAction exit = new ExitUIAction();
    private static SystemUserLogin systemLogin = new UserLoginSystem();


    public static void main(String[] args) {

        User user = systemLogin.login();
        if (user != null) {
            while (true) {
                printMenu();
                int getUserMenuChoice = getUserMenuChoice();
                executeSelectedMenuItem(dataBase, getUserMenuChoice, user.getUserLogin());
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

    public static void executeSelectedMenuItem(DateBaseIf dataBase, int getUSerMenuChoice,String userLogin) {

        switch (getUSerMenuChoice) {
            case 1: {
                addCake.execute(userLogin);
                break;
            }

            case 2: {
                getCakeForClient.execute(userLogin);
                break;
            }
            case 3: {
                exit.execute(userLogin);
            }
        }
    }
}
