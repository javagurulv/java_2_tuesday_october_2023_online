package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.UpdateClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.UpdateClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.UpdateClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UpdateClientUIAction implements UIAction {

    @Autowired private UpdateClientService updateClientService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client id to update: ");
        Long clientId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter new first name: ");
        String newFirstName = scanner.nextLine();
        System.out.println("Enter new last name: ");
        String newLastName = scanner.nextLine();
        System.out.println("Enter new personal code: ");
        String newPersonalCode = scanner.nextLine();
        UpdateClientRequest request = new UpdateClientRequest(clientId, newFirstName, newLastName, newPersonalCode);
        UpdateClientResponse response = updateClientService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("Your client was updated" + response.getUpdatedClient());

        }
    }
}
