
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CakeConstructor {

    public static void main(String[] args) {
        ListOfIngridients list = new ListOfIngridients();
        List<Biscuit> biscuits = list.createListOfBiscuit();
        List<Filling> fillings = list.createListOfFilling();
        List<Shell> shells = list.createListOfShell();
        List<Decor> decors = list.createListOfDecor();
        List<Cake> cakeConstructor = new ArrayList<>();

        while (true) {
            System.out.println("Welcome to cake constructor!");
            System.out.println("Press 1 - create a cake");
            System.out.println("Press 2 - check order ");
            System.out.println("Press 3 - exit");

            Scanner scan = new Scanner(System.in);
            int userChoice = scan.nextInt();

            switch (userChoice) {
                case 1: {
                    System.out.println("Choose a biscuit!");
                    list.printListOfBiscuit(biscuits);
                    String biscuit = scan.nextLine();
                    int price = list.priceBiscuit(biscuits, biscuit);


                    System.out.println("Choose a filling!");
                    list.printListOfFilling(fillings);
                    String filling = scan.nextLine();
                    price = list.priceFilling(fillings, filling) + price;


                    System.out.println("Choose a shell!");
                    list.printListOfShell(shells);
                    String shell = scan.nextLine();
                    price = list.priceShell(shells, shell) + price;


                    System.out.println("Choose a decor!");
                    list.printListOfDecor(decors);
                    String decor = scan.nextLine();
                    price = list.priceDecor(decors, decor) + price;


                    System.out.println("Please, enter your client ID!");
                    int clientId = scan.nextInt();
                    Cake cake = new Cake(biscuit, filling, shell, decor, clientId, price);
                    cakeConstructor.add(cake);
                }

                case 2: {
                    System.out.println("Please enter your client ID!");
                    int clientId = scan.nextInt();
                    for (Cake cake : cakeConstructor) {
                        if (clientId == cake.getClientId()) {
                            cake.toString();
                        }
                    }

                }
                case 3: {
                    System.out.println("Thank you for being with us!");
                    System.exit(0);
                }

            }
        }

    }
}
