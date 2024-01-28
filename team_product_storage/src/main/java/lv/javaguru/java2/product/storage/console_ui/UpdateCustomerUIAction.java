package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.requests.UpdateCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.UpdateCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UpdateCustomerUIAction implements UIAction {

    @Autowired private UpdateCustomerService updateCustomerService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer id to update: ");
        Long customerId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter new customer name: ");
        String newCustomerName = scanner.nextLine();
        System.out.println("Enter new registration code: ");
        String newRegistrationCode = scanner.nextLine();
        UpdateCustomerRequest request = new UpdateCustomerRequest(customerId, newCustomerName, newRegistrationCode);
        UpdateCustomerResponse response = updateCustomerService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getErrorCode() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("Your customer was updated" + response.getUpdatedCustomer());

        }
    }
}
