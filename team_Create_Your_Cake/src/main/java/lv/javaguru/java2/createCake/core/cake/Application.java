package lv.javaguru.java2.createCake.core.cake;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        List<Cake> cakes = new ArrayList<>();

        while (true){
            printMenuBeforeRegistration();
            int userChoice = getUserChoice();
            switch (userChoice){
                case 1 : {

                }
                case 2: {

                }
                case 3: {

                }
                case 4:{
                    exitProgram();
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

    private static void printMenuAfterRegistrationClient (User client){
        System.out.println("Welcome " + client.getUserName());
        System.out.println("Press 1 - create cake!");
        System.out.println("Press 2 - check order");
        System.out.println("Press 3 - privies order ");
        System.out.println("Press 4 - Exit");
    }

    private static void printMenuAfterRegistrationAdmin (User admin){
        System.out.println("Welcome " + admin.getUserName());
        System.out.println("Press 1 - clients");
        System.out.println("Press 2 - list of order");
        System.out.println("Press 3 - Statistics");
        System.out.println("Press 4 - Exit");
    }

    private static void exitProgram(){
        System.out.println(" Thank you! ");
        System.exit(0);
    }

    private static  int getUserChoice(){
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        return choice;
    }

}
