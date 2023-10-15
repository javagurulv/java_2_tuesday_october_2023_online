package ui;

import services.DeleteProductService;

import java.util.Scanner;

public class DeleteProductUIAction {

    private DeleteProductService service;

    public DeleteProductUIAction(DeleteProductService service) {
        this.service = service;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter product ID: ");
        Long productID = scanner.nextLong();

        service.deleteProduct(productName, productID);

        System.out.println("domain.Product was removed from the list: ");

    }
}
