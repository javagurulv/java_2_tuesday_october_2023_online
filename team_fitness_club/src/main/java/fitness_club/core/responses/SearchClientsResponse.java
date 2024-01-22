package fitness_club.core.responses;

import fitness_club.core.domain.Client;

import java.util.List;

public class SearchClientsResponse extends CoreResponse {
    private List<Client> foundClients;
    public SearchClientsResponse(List<Client> foundClients, List<CoreError> errors) {
        super(errors);
        this.foundClients = foundClients;
    }

    public List<Client> getFoundClients() { return foundClients; }
}
