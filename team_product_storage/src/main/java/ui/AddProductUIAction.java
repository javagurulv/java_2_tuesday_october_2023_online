package ui;

import services.AddProductService;

import java.util.Scanner;

public class AddProductUIAction {

    private AddProductService service;

    public AddProductUIAction(AddProductService service) {
        this.service = service;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter product ID: ");
        Long productID = scanner.nextLong();

        service.addProduct(productName, productID);

        System.out.println("domain.Product was added to the list: ");
    }
}
