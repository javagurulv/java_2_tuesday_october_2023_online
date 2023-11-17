package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.AddProductResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.dependency_injection.DIComponent;
import lv.javaguru.java2.product.storage.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class AddProductUIAction implements UIAction {

    @DIDependency private AddProductService addProductService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter product brand: ");
        String productBrand = scanner.nextLine();
        System.out.println("Enter product model: ");
        String productModel = scanner.nextLine();
        AddProductRequest request = new AddProductRequest(productName, productBrand, productModel);
        AddProductResponse response = addProductService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("New product id was: " + response.getNewProduct().getId());
            System.out.println("Your product was added to list.");
        }
    }
}
