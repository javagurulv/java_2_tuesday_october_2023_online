package lv.javaguru.java2.cakeConstructor.newApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<Ingridient> ingridients = new ArrayList<>();

        while (true){
            printProgramMenu();
            int userChoice = getUserChoice();
            switch (userChoice){
                case 1:{
                    addIngridient(ingridients);
                    break;
                }
                case 2:{
                    removeIngridient(ingridients);
                    break;
                }
                case 3:{
                    printIngridient(ingridients);
                    break;
                }
                case 4:{
                    exitProgram();
                }
            }
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
    private static void exitProgram() {
        System.out.println("Good by!");
        System.exit(0);
    }

    private static void printIngridient(List<Ingridient> ingridients) {
        System.out.println("Ingridient list: ");
        for (Ingridient ingridient : ingridients) {
            System.out.println(ingridient);
        }
        System.out.println("Ingridient list end.");
    }

    private static void removeIngridient(List<Ingridient> ingridients) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter type of ingridient: ");
        String typeOfIngridient= scanner.nextLine();
        System.out.println("Enter taste of ingridient: ");
        String tasteOfIngridient = scanner.nextLine();
        ingridients.remove(new Ingridient(typeOfIngridient, tasteOfIngridient));
        System.out.println("Your ingridient was removed from list.");
    }

    private static void addIngridient(List<Ingridient> ingridients) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter type of ingridient: ");
        String typeOfIngridient = scanner.nextLine();
        System.out.println("Enter taste of ingridient: ");
        String tasteOfIngridient = scanner.nextLine();
        Ingridient ingridient = new Ingridient(typeOfIngridient, tasteOfIngridient);
        ingridients.add(ingridient);
        System.out.println("Your book was added to list.");
    }
}
