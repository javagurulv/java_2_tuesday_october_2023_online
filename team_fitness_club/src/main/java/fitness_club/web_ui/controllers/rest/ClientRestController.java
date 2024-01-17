package fitness_club.web_ui.controllers.rest;

import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.GetClientRequest;
import fitness_club.core.requests.DeleteClientByIdRequest;
import fitness_club.core.requests.UpdateClientRequest;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.core.responses.DeleteClientByIdResponse;
import fitness_club.core.responses.GetClientResponse;
import fitness_club.core.responses.UpdateClientResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.GetClientService;
import fitness_club.core.services.DeleteClientByIdService;
import fitness_club.core.services.UpdateClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientRestController {

    @Autowired
    private GetClientService getClientService;
    @Autowired
    private AddClientService addClientService;
    @Autowired
    private UpdateClientService updateClientService;
    @Autowired
    private DeleteClientByIdService deleteClientService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public GetClientResponse getClient(@PathVariable Long id) {
        GetClientRequest request = new GetClientRequest(id);
        return getClientService.execute(request);
    }

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddClientResponse addClient(@RequestBody AddClientRequest request) {
        return addClientService.execute(request);
    }

    @PostMapping(path = "/{id}",
            consumes = "application/json",
            produces = "application/json")
    public UpdateClientResponse updateClient(@RequestBody UpdateClientRequest request) {
        return updateClientService.execute(request);
    }
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public DeleteClientByIdResponse deleteClient(@PathVariable Long id) {
        DeleteClientByIdRequest request = new DeleteClientByIdRequest(id);
        return deleteClientService.executeByClientId(request);
    }
}
