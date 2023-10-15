import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StorageApplication {

    private static int getUserMenuChoice() {
        System.out.println("Enter menu item number to execute ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void main(String[] args) {
        Database database = new InMemoryDatabase();

        AddProductService addProductService = new AddProductService(database);
        DeleteProductService deleteProductService = new DeleteProductService(database);
        GetAllProductsService getAllProductService = new GetAllProductsService(database);

        AddProductUIAction addProductUIAction = new AddProductUIAction(addProductService);
        DeleteProductUIAction deleteProductUIAction = new DeleteProductUIAction(deleteProductService);
        PrintAllProductsUIAction printAllProductsUIAction = new PrintAllProductsUIAction(getAllProductService);
        ExitProgramUIAction exitProgramUIAction = new ExitProgramUIAction();


        while (true) {
            printMenu();

            int userChoice = getUserMenuChoice();

            switch (userChoice) {
                case 1: {
                    addProductUIAction.execute();
                    break;
                }
                case 2: {
                    deleteProductUIAction.execute();
                    break;
                }
                case 3: {
                    printAllProductsUIAction.execute();
                    break;
                }
                case 4: {
                    exitProgramUIAction.execute();
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Menu: ");
        System.out.println("1.Add product to list: ");
        System.out.println("2.Remove product from list: ");
        System.out.println("3.Display all products in the list: ");
        System.out.println("4.Exit from program");

        System.out.println("");
    }
}
