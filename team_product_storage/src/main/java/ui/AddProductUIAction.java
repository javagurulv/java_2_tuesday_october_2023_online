package ui;

import services.AddProductService;

import java.util.Scanner;

public class AddProductUIAction implements UIAction{

    private AddProductService addProductService;

    public AddProductUIAction(AddProductService addProductService) {
        this.addProductService = addProductService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter product ID: ");
        Long productID = scanner.nextLong();

        addProductService.execute(productName, productID);

        System.out.println("domain.Product was added to the list: ");
    }
}
