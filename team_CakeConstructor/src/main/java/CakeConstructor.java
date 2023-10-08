import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CakeConstructor {

    public static void main(String[] args) {
        List<Cake> cakeConstructor = new ArrayList<>();

        while (true){
            System.out.println("Welcome to cake constructor!");
            System.out.println("Please chose a type of cake.");
            System.out.println("Press 1 - for mousse cake.");
            System.out.println("Press 2 for sponge cake!");
            System.out.println("Press 3 to check your order!");
            System.out.println("Exit. Press 4");

            Scanner scan = new Scanner(System.in);
            int userChoice = scan.nextInt();

            switch (userChoice){
                case 1:{
                    System.out.println("Enter a biscuit you want - ");
                    System.out.println("As an example - chocolate or vanilla");
                    String biscuit = scan.nextLine();
                    System.out.println("Enter your favorite cakeFilling");
                    String cakeFilling = scan.nextLine();
                    System.out.println("Enter mousse taste");
                    String cakeShell = scan.nextLine();
                    System.out.println("Chose decor for cake  - velvet or mirror glaze");
                    String cakeDecor = scan.nextLine();
                    System.out.println("Enter your clientID " );
                    int clientId = scan.nextInt();
                    Cake cake = new Cake(clientId,userChoice,biscuit,cakeFilling,cakeShell,cakeDecor);
                    cakeConstructor.add(cake);
                    System.out.println("Thank you for order! We will call you in 5 min!");
                    break;
                }
                case 2:{
                    System.out.println("Enter a biscuit you want - ");
                    System.out.println("As an example - chocolate or vanilla");
                    String biscuit = scan.nextLine();
                    System.out.println("Enter your favorite cakeFilling");
                    String cakeFilling = scan.nextLine();
                    System.out.println("Enter taste for cream cheese - ");
                    String cakeShell = scan.nextLine();
                    System.out.println("Chose a colour of your cake");
                    String cakeDecor = scan.nextLine();
                    System.out.println("Enter your clientID " );
                    int clientId = scan.nextInt();
                    Cake cake = new Cake(clientId,userChoice,biscuit,cakeFilling,cakeShell,cakeDecor);
                    cakeConstructor.add(cake);
                    System.out.println("Thank you for order! We will call you in 5 min!");
                    break;

                }
                case 3: {
                    System.out.println("Please enter your clientID");
                    int clientId = scan.nextInt();
                    for (Cake cake : cakeConstructor) {
                        if (clientId == cake.getClientId()) {
                            System.out.println("Found cake order for client ID :" + clientId);
                            System.out.println("Client ID: " + cake.getClientId());
                            System.out.println("Biscuit: " + cake.getBiscuit());
                            System.out.println("Cake Filling: " + cake.getCakeFilling());
                            System.out.println("Cake Shell: " + cake.getCakeShell());
                            System.out.println("Cake Decoration: " + cake.getCakeDecor());
                        } else {
                            System.out.println("Not Found cake order for client ID:" + clientId);
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("See you again!");
                    System.exit(0);
                }
            }
        }
    }
}
