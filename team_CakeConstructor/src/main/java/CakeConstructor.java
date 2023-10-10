
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CakeConstructor {

    public static void main(String[] args) {
        ListOfIngridients list = new ListOfIngridients();
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
                    System.out.println("Please, enter your client ID!");
                    int clientId = scan.nextInt();

                    cakeConstructor = list.createCake(clientId);
                    break;

                }

                case 2: {
                    System.out.println("Please enter your client ID!");
                    int clientId = scan.nextInt();
                    for (Cake cake : cakeConstructor) {
                        if (clientId == cake.getClientId()) {
                            System.out.println(cake);
                        }
                    }
                    System.out.println("  ");
                    break;
                }
                case 3: {
                    System.out.println("Thank you for being with us!");
                    System.exit(0);
                }

            }
        }

    }
}
