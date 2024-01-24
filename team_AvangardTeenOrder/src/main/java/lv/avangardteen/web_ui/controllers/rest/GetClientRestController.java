package lv.avangardteen.web_ui.controllers.rest;

import lv.avangardteen.core.request.GetClientRequest;
import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.responce.GetClientResponse;
import lv.avangardteen.core.responce.UserRegistrationResponse;
import lv.avangardteen.core.service.GetClientService;
import lv.avangardteen.core.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class GetClientRestController {
    @Autowired
    private GetClientService getClientService;

    @Autowired private UserRegistrationService userRegistrationService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public GetClientResponse getClient(@PathVariable Long id) {
        GetClientRequest request = new GetClientRequest(id);
        return getClientService.execute(request);
    }



    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public UserRegistrationResponse addClient(@RequestBody UserRegistrationRequest request) {
        return userRegistrationService.execute(request);
    }

}
