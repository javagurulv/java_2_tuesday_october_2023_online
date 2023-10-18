package lv.simpleInventory.console_UI;

import lv.simpleInventory.services.AddProductService;

import java.util.Scanner;

public class AddProductsUIAction implements UIAction {


    private AddProductService addProductService;
    public AddProductsUIAction(AddProductService addProductService){
        this.addProductService = addProductService;
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
        addProductService.execute(productName,productCount,productPrice);
        System.out.println("Product has been added to the list");

    }
}
