
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CakeConstructor {
    static Scanner scan = new Scanner(System.in);
    static ListOfIngridients list = new ListOfIngridients();
    public static void main(String[] args) {

        List<Cake> cakeConstructor = new ArrayList<>();

        while (true) {

            printMenu();
            int userChoice = getUserMenuChoice();

            switch (userChoice) {
                case 1: {
                    cakeConstructor = createCake();
                    break;
                }

                case 2: {
                    printOrderForClientId(cakeConstructor);
                    break;
                }
                case 3: {
                    printEndOfApp();
                }

            }
        }
    }


    public  static  List<Cake> createCake(){
        List<Cake> cake = new ArrayList<>();
        System.out.println("Please, enter your client ID!");
        int clientId = scan.nextInt();
        cake = list.createCake(clientId);
        return cake;
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

    public static void printOrderForClientId(List<Cake> cakeConstructor){
        System.out.println("Please enter your client ID!");
        int clientId = scan.nextInt();
        for (Cake cake : cakeConstructor) {
            if (clientId == cake.getClientId()) {
                System.out.println(cake);
            }
        }
        System.out.println("  ");
    }

    public static void printEndOfApp(){
        System.out.println("Thank you for being with us!");
        System.exit(0);
    }

}
