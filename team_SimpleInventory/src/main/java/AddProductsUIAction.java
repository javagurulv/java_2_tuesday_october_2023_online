import java.util.Scanner;

public class AddProductsUIAction implements UIAction {

    private Database database;
    public AddProductsUIAction(Database database){
        this.database = database;
    }



    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name");
        String productName = scanner.nextLine();
        System.out.println("Enter product count");
        int productCount = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter product price");
        double productPrice = Double.parseDouble(scanner.nextLine());
        Product product = new Product(productName, productCount, productPrice);
        database.add(product);
        System.out.println("Product has been added to the list");

    }
}
