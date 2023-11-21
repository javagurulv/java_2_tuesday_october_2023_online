package fitness_club.core.responses;

import fitness_club.core.domain.Client;
import fitness_club.core.services.data_vlidation.CoreError;
import fitness_club.core.services.data_vlidation.CoreResponse;

import java.util.List;

public class SearchClientResponse extends CoreResponse {
    private List<Client> foundClients;
    public SearchClientResponse(List<Client> foundClients, List<CoreError> errors) {
        super(errors);
        this.foundClients = foundClients;
    }

    public List<Client> getFoundClients() { return foundClients; }
}
