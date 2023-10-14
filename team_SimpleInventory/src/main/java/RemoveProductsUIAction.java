import java.util.Scanner;

public class RemoveProductsUIAction implements UIAction {

    private Database database;

    public RemoveProductsUIAction(Database database){
        this.database = database;
    }



    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID");
        Long productId = Long.parseLong(scanner.nextLine());
        database.remove(productId);
        System.out.println("Product has been removed");

    }
}
