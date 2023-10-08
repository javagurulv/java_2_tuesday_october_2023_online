import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        while (true){
            System.out.println("Inventory Menu");
            System.out.println("1.Add product");
            System.out.println("2.Remove product");
            System.out.println("3.View all products");
            System.out.println("4.Close application");
            System.out.println("");

            System.out.println("What do you want to do?");
            Scanner scanner = new Scanner(System.in);
            int selectedNumber = Integer.parseInt(scanner.nextLine());

            switch (selectedNumber){
                case 1:{
                    System.out.println("Enter product name");
                    String productName = scanner.nextLine();
                    System.out.println("Enter product count");
                    int productCount = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter product price");
                    double productPrice = Double.parseDouble(scanner.nextLine());
                    Product product = new Product(productName,productCount,productPrice);
                    products.add(product);
                    System.out.println("Product has been added to the list");
                    break;
                }
                case 2:{
                    System.out.println("Enter product name");
                    String productName = scanner.nextLine();
                    System.out.println("Enter product count");
                    int productCount = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter product price");
                    double productPrice = Double.parseDouble(scanner.nextLine());
                    products.remove(new Product(productName,productCount,productPrice));
                    System.out.println("Product has been removed");
                    break;
                }
                case 3:{
                    System.out.println("PRODUCT LIST");
                    for (Product product : products){
                        System.out.println(product);
                    }
                    break;
                }
                case 4:{
                    System.out.println("See Ya!");
                    System.exit(0);
                }

            }

        }

    }
}
