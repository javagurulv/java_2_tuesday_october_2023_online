package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;
import lv.javaguru.java2.product.storage.core.services.RemoveProductService;
import lv.javaguru.java2.product.storage.dependency_injection.DIComponent;
import lv.javaguru.java2.product.storage.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class RemoveProductUIAction implements UIAction {

    @DIDependency private RemoveProductService removeProductService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id to remove: ");
        Long productId = Long.parseLong(scanner.nextLine());
        RemoveProductRequest request = new RemoveProductRequest(productId);
        RemoveProductResponse response = removeProductService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isProductRemoved()) {
                System.out.println("Your product was removed from list.");
            } else {
                System.out.println("Your product not removed from list. Please enter valid id!");
            }
        }
    }
}
