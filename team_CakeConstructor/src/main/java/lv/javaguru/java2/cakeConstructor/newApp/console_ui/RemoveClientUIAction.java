package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.RemoveClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveClientUIAction implements UIAction {

    @Autowired
    private RemoveClientService removeClientService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client id to remove: ");
        Long clientId = Long.parseLong(scanner.nextLine());
        RemoveClientRequest request = new RemoveClientRequest(clientId);
        RemoveClientResponse response = removeClientService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isClientRemoved()) {
                System.out.println("Your client was removed from list.");
            } else {
                System.out.println("Your client not removed from list. Please enter valid id!");
            }
        }
    }
}
