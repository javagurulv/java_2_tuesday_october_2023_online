import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StorageApplication {


    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        while (true) {
            printMenu();

            int userChoice = getUserMenuChoice();

            switch (userChoice) {
                case 1: {
                    addNewProductToList(products);
                    break;
                }
                case 2: {
                    removeProductFromList(products);
                    break;
                }
                case 3: {
                    printProductList(products);
                    break;
                }
                case 4: {
                    exitFromProgram();
                }
            }
        }
    }

    private static int getUserMenuChoice() {
        System.out.println("Enter menu item number to execute ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
    private static void exitFromProgram() {
        System.out.println("Exit!");
        System.exit(0);
    }

    private static void printProductList(List<Product> products) {
        System.out.println("All product list: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void removeProductFromList(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter product ID Number: ");
        String productIDNumber = scanner.nextLine();
        Product product = new Product(productName, productIDNumber);
        products.remove(product);
        System.out.println("Product was removed from the list: ");
    }

    private static void addNewProductToList(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter product ID Number: ");
        String productIDNumber = scanner.nextLine();
        Product product = new Product(productName, productIDNumber);
        products.add(product);
        System.out.println("Product was added to the list: ");
    }

    private static void printMenu() {
        System.out.println("Menu: ");
        System.out.println("1. Add product to list: ");
        System.out.println("2. Remove product from list: ");
        System.out.println("3. Display all products in the list: ");
        System.out.println("4. Exit from program");

        System.out.println("");
    }
}
