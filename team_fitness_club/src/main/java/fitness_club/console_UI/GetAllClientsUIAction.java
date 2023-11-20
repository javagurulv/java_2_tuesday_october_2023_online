package fitness_club.console_UI;

import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.responses.GetAllClientsResponse;
import fitness_club.core.services.GetAllClientsService;
import fitness_club.dependency_injection.DIComponent;
import fitness_club.dependency_injection.DIDependency;

@DIComponent
public class GetAllClientsUIAction implements UIAction {
    @DIDependency private GetAllClientsService getAllClientsService;


    @Override
    public void execute() {
        System.out.println("Clients list: ");
        GetAllClientsRequest request = new GetAllClientsRequest();
        GetAllClientsResponse response = getAllClientsService.execute(request);
        response.getClients().forEach(System.out::println);
        System.out.println("Client list end.");
    }
}
