package fitness_club.console_UI;

import fitness_club.domain.Client;
import fitness_club.services.GetAllClientsService;

public class GetAllClientsUIAction implements UIAction {
    private GetAllClientsService service;

    public GetAllClientsUIAction(GetAllClientsService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("Clients list: ");

        for (Client client : service.getAllClients()) {
            System.out.println(client);
        }

        System.out.println("Client list end.");
    }
}
