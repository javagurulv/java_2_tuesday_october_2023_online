package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;
import lv.javaguru.java2.product.storage.core.services.RemoveProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveProductUIAction implements UIAction {

    @Autowired
    private RemoveProductService removeProductService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id to remove: ");
        Long productId = Long.parseLong(scanner.nextLine());
        RemoveProductRequest request = new RemoveProductRequest(productId);
        RemoveProductResponse response = removeProductService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getErrorCode() + " " + coreError.getMessage()));
        } else {
            if (response.isProductRemoved()) {
                System.out.println("Your product was removed from list.");
            } else {
                System.out.println("Your product not removed from list. Please enter valid id!");
            }
        }
    }
}
