package fitness_club.console_UI;

import fitness_club.core.requests.RemoveClientByIdRequest;
import fitness_club.core.responses.RemoveClientByIdResponse;
import fitness_club.core.services.RemoveClientByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveClientUIAction implements UIAction {
    @Autowired
    private RemoveClientByIdService removeClientByIdService;


    @Override
    public void execute() {
      Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client id to remove: ");
        Long clientId = Long.parseLong(scanner.nextLine());
        RemoveClientByIdRequest request = new RemoveClientByIdRequest(clientId);
        RemoveClientByIdResponse response =
                removeClientByIdService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Alarm: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isClientRemoved()) {
                System.out.println("Client was removed from list.");
            } else {
                System.out.println("Client was not removed from list.");
            }
        }
    }
}

