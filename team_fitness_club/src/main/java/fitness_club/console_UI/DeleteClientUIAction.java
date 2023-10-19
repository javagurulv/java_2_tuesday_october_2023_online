package fitness_club.console_UI;

import fitness_club.services.DeleteClientService;

import java.util.Scanner;

public class DeleteClientUIAction implements UIAction {
    private DeleteClientService service;

    public DeleteClientUIAction(DeleteClientService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();
        DeleteClientRequest request = new DeleteClientRequest(clientPersonalCode);
        DeleteClientResponse response = service.removeClient(request);
        service.removeClient(clientPersonalCode);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isClientRemoved) {
                System.out.println("Client was removed from  list.");
            } else {
                System.out.println("Client was removed from  list.");
            }
        }
    }
}

