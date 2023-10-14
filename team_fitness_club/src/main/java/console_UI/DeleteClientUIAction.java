package console_UI;

import services.DeleteClientService;

import java.util.Scanner;

public class DeleteClientUIAction implements UIAction {
    private DeleteClientService service;

    public DeleteClientUIAction(DeleteClientService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client first name: ");
        String clientFirstName = scanner.nextLine();
        System.out.println("Enter client last name: ");
        String clientLastName = scanner.nextLine();
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();

        service.removeClient(clientFirstName, clientLastName, clientPersonalCode);

        System.out.println("Client was removed from list. ");
    }
}

