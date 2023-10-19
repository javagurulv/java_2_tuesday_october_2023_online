package lv.javaguru.java2.product.storage.ui;

import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.AddProductResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;

import java.util.Scanner;

public class AddProductUIAction implements UIAction {

    private AddProductService addProductService;

    public AddProductUIAction(AddProductService addProductService) {
        this.addProductService = addProductService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        AddProductRequest request = new AddProductRequest(productName);
        AddProductResponse response = addProductService.execute(request);
        System.out.println("New product id was: " + response.getNewProduct().getId());
        System.out.println("Your product was added to list.");
    }
}
