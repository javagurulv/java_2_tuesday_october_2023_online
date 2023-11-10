package fitness_club.console_UI;

import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.responses.GetAllClientsResponse;
import fitness_club.core.services.GetAllClientsService;

public class GetAllClientsUIAction implements UIAction {
    private GetAllClientsService getAllClientsService;

    public GetAllClientsUIAction(GetAllClientsService getAllClientsService) {
        this.getAllClientsService = getAllClientsService;
    }

    @Override
    public void execute() {
        System.out.println("Clients list: ");
        GetAllClientsRequest request = new GetAllClientsRequest();
        GetAllClientsResponse response = getAllClientsService.execute(request);
        response.getClients().forEach(System.out::println);
        System.out.println("Client list end.");
    }
}
