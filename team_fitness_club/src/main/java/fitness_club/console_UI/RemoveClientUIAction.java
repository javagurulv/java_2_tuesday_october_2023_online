package fitness_club.console_UI;

import fitness_club.core.requests.RemoveClientRequest;
import fitness_club.core.responses.RemoveClientResponse;
import fitness_club.core.services.DeleteClientService;
import fitness_club.dependency_injection.DIComponent;
import fitness_club.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class RemoveClientUIAction implements UIAction {
    @DIDependency private DeleteClientService deleteClientService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();
        RemoveClientRequest request = new RemoveClientRequest(clientPersonalCode);
        RemoveClientResponse response = deleteClientService.execute(request);
        deleteClientService.execute(request);

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

