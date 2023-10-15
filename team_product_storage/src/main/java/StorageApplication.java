import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StorageApplication {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        while (true) {
            System.out.println("Menu: ");
            System.out.println("Add product to list: ");
            System.out.println("Delete product from list: ");
            System.out.println("Display all products in the list: ");
            System.out.println("Exit from program");

            System.out.println("");

            System.out.println("Enter menu item number to execute ");
            Scanner scanner = new Scanner(System.in);
            int userChoice = Integer.parseInt(scanner.nextLine());

            switch(userChoice) {
                case 1: {
                    System.out.println("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.println("Enter product ID Number: ");
                    String productIDNumber = scanner.nextLine();
                    Product product = new Product(productName, productIDNumber);
                    products.add(product);
                    System.out.println("Product was added to the list: ");
                    break;
                }
                case 2: {
                    System.out.println("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.println("Enter product ID Number: ");
                    String productIDNumber = scanner.nextLine();
                    Product product = new Product(productName, productIDNumber);
                    products.remove(product);
                    System.out.println("Product was removed from the list: ");
                    break;
                }
                case 3: {
                    System.out.println("All product list: ");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Exit!");
                    System.exit(0);
                }
            }
        }
    }
}
