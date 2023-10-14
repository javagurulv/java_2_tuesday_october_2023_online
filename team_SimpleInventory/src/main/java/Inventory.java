import java.util.Scanner;

public class Inventory {

    private static Database database = new InMemoryDatabase();
    private static UIAction addProductAction = new AddProductsUIAction(database);
    private static UIAction removeProductAction = new RemoveProductsUIAction(database);
    private static UIAction getAllProductAction = new GetAllProductsUIAction(database);
    private static UIAction exitProductsAction = new ExitProductsUiAction();


    public static void main(String[] args) {
        Database database = new InMemoryDatabase();
        while (true) {
            printMenu();
            int selectedNumber = usersChoice();
            executeMenu(database, selectedNumber);

        }

    }

    private static void executeMenu(Database database, int selectedNumber) {
        switch (selectedNumber) {
            case 1: {
                addProductAction.execute();
                break;
            }
            case 2: {
                removeProductAction.execute();
                break;
            }
            case 3: {
                getAllProductAction.execute();
                break;
            }
            case 4: {
                exitProductsAction.execute();
            }

        }
    }

    private static int usersChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String printMenu() {
        System.out.println("Inventory Menu");
        System.out.println("1.Add product");
        System.out.println("2.Remove product");
        System.out.println("3.View all products");
        System.out.println("4.Close application");
        System.out.println("");
        return null;
    }
}


