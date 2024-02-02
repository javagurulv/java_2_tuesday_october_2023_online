package fitness_club.web_ui.controllers.rest;


import fitness_club.core.requests.*;
import fitness_club.core.responses.*;
import fitness_club.core.services.*;
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
    private RemoveClientByPersonalCodeService deleteClientService;

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

    @PutMapping(path = "/{id}",
            consumes = "application/json",
            produces = "application/json")
    public UpdateClientResponse updateClient(@RequestBody UpdateClientRequest request) {
        return updateClientService.execute(request);
    }

    @DeleteMapping(path = "/{personalCode}", produces = "application/json")
    public RemoveClientByPersonalCodeResponse deleteClient(@PathVariable String personalCode) {
        RemoveClientByPersonalCodeRequest request = new RemoveClientByPersonalCodeRequest(personalCode);
        return deleteClientService.execute(request);
    }
}
