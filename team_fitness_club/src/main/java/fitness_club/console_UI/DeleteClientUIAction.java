package fitness_club.console_UI;

import fitness_club.core.requests.DeleteClientRequest;
import fitness_club.core.responses.DeleteClientResponse;
import fitness_club.core.services.DeleteClientService;

import java.util.Scanner;

public class DeleteClientUIAction implements UIAction {
    private DeleteClientService deleteClientService;

    public DeleteClientUIAction(DeleteClientService deleteClientService) {
        this.deleteClientService = deleteClientService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();
        DeleteClientRequest request = new DeleteClientRequest(clientPersonalCode);
        DeleteClientResponse response = deleteClientService.execute(request);
        deleteClientService.execute(request);

        if (response.containsErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isClientDeleted()) {
                System.out.println("Client was removed from  list.");
            } else {
                System.out.println("Client was removed from  list.");
            }
        }
    }
}

