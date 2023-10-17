package ui;

import services.RemoveProductService;

import java.util.Scanner;

public class RemoveProductUIAction implements UIAction{

    private RemoveProductService removeProductService;

    public RemoveProductUIAction(RemoveProductService deleteProductService) {
        this.removeProductService = deleteProductService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter product ID: ");
        Long productID = scanner.nextLong();

        removeProductService.execute(productName, productID);

        System.out.println("domain.Product was removed from the list: ");

    }
}
