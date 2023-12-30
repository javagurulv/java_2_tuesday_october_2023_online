package fitness_club.console_UI;

import fitness_club.core.requests.RegisterClientRequest;
import fitness_club.core.responses.RegisterClientResponse;
import fitness_club.core.services.RegisterClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class RegisterClientUIAction implements UIAction {

    @Autowired private RegisterClientService registerClientService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client first name: ");
        String clientFirstName = scanner.nextLine();
        System.out.println("Enter client last name: ");
        String clientLastName = scanner.nextLine();
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();

        RegisterClientRequest request = new RegisterClientRequest(clientFirstName, clientLastName, clientPersonalCode);
        RegisterClientResponse response = registerClientService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("New client id was: " + response.getNewClient().getId());
            System.out.println("Client was added to list.");
        }
    }
}
