
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class CakeConstructor {
    static Scanner scan = new Scanner(System.in);
    static ListOfIngridients list = new ListOfIngridients();

    public static void main(String[] args) {
        DateBaseIf dataBase = new DataBase();

        while (true) {
            printMenu();
            int getUserMenuChoice = getUserMenuChoice();
            executeSelectedMenuItem(dataBase, getUserMenuChoice);
        }
    }

        public static void executeSelectedMenuItem(DateBaseIf dataBase, int getUSerMenuChoice) {

            switch (getUSerMenuChoice) {
                case 1: {
                    createCake(dataBase);
                    break;
                }

                case 2: {
                    printOrderForClientId(dataBase);
                    break;
                }
                case 3: {
                    printEndOfApp();
                }

            }
        }


    public  static  void createCake(DateBaseIf dateBase){
        System.out.println("Please, enter your client ID!");
        int clientId = scan.nextInt();
        List<Cake> cakes = list.createCake(clientId);
        for (Cake cake : cakes) {
            dateBase.add(cake);
        }
    }
    public static void printMenu(){
        System.out.println("Welcome to cake constructor!");
        System.out.println("Press 1 - create a cake");
        System.out.println("Press 2 - check order ");
        System.out.println("Press 3 - exit");
    }

    public static int getUserMenuChoice(){

        int userChoice = scan.nextInt();
        return userChoice;
    }

    public static void printOrderForClientId(DateBaseIf dataBase) {
        System.out.println("Please enter your client ID!");
        int clientId = scan.nextInt();
        List<Cake> cakes = dataBase.getAllCake();
        for (Cake cake : cakes) {
            if (clientId == cake.getClientId()) {
                System.out.println(cake.toString());
            }
        }
    }

    public static void printEndOfApp(){
        System.out.println("Thank you for being with us!");
        System.exit(0);
    }


}
