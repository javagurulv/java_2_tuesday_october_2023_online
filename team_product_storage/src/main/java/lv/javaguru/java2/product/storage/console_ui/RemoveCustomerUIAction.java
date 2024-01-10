package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.requests.RemoveCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.RemoveCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.RemoveCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveCustomerUIAction implements UIAction {

    @Autowired
    private RemoveCustomerService removeCustomerService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer id to remove: ");
        Long customerId = Long.parseLong(scanner.nextLine());
        RemoveCustomerRequest request = new RemoveCustomerRequest(customerId);
        RemoveCustomerResponse response = removeCustomerService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getErrorCode() + " " + coreError.getMessage()));
        } else {
            if (response.isCustomerRemoved()) {
                System.out.println("Your customer was removed from list.");
            } else {
                System.out.println("Your customer not removed from list. Please enter valid id!");
            }
        }
    }
}
