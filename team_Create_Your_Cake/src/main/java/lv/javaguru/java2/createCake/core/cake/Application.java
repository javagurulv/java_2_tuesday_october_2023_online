package lv.javaguru.java2.createCake.core.cake;

import lv.javaguru.java2.createCake.core.cake.UI.UIAction;
import lv.javaguru.java2.createCake.core.cake.UI.add_cake.AddCakeForUnregistrUIActionApp;
import lv.javaguru.java2.createCake.core.cake.UI.check_order.CheckOrderUIActionForUnregistr;
import lv.javaguru.java2.createCake.core.cake.UI.exit.ExitUIAction;
import lv.javaguru.java2.createCake.core.cake.UI.registration.RegistrationAndEntrenceUIAction;


import java.util.Scanner;

public class Application {

    private static UIAction registration = new RegistrationAndEntrenceUIAction();
    private static UIAction addCake = new AddCakeForUnregistrUIActionApp();
    private  static UIAction checkOrder = new CheckOrderUIActionForUnregistr();
    private static UIAction exit = new ExitUIAction();


    public static void main(String[] args) {

        while (true) {
            printMenuBeforeRegistration();
            int userChoice = getUserChoice();
            switch (userChoice) {
                case 1: {
                    registration.execute();
                    break;
                }
                case 2: {
                    addCake.execute();
                    break;
                }
                case 3: {
                    checkOrder.execute();
                    break;
                }
                case 4: {
                    exit.execute();
                }
            }
        }
    }






    private static void printMenuBeforeRegistration (){
        System.out.println("Welcome!!");
        System.out.println("Press 1 - registration/login");
        System.out.println("Press 2 - create order");
        System.out.println("Press 3 - check order");
        System.out.println("Press 4 - Exit");
    }




    private static  int getUserChoice(){
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        return choice;
    }

}
