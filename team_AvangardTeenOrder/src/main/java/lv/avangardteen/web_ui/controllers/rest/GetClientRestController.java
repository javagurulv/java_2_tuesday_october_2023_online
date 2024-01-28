package lv.avangardteen.web_ui.controllers.rest;

import lv.avangardteen.core.request.GetClientRequest;
import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.responce.GetClientResponse;
import lv.avangardteen.core.responce.UserRegistrationResponse;
import lv.avangardteen.core.service.GetClientService;
import lv.avangardteen.core.service.UserRegistrationService;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class GetClientRestController {

    @Autowired private UserRegistrationRequestLogger requestLogger;
    @Autowired private UserRegistrationResponseLogger responseLogger;
    @Autowired private GetClientRequestLogger getClientRequestLogger;
    @Autowired private GetClientResponseLogger getClientResponseLogger;
    @Autowired private GetClientService getClientService;
    @Autowired private UserRegistrationService userRegistrationService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public GetClientResponse getClient(@PathVariable Long id) {

        GetClientRequest request = new GetClientRequest(id);
        GetClientResponse response = processRequest(request);
        return response;
    }

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public UserRegistrationResponse addClient(@RequestBody UserRegistrationRequest request) {
        UserRegistrationResponse responseRegistration = processRequestRegistration(request);
        return responseRegistration;
    }

    private GetClientResponse processRequest(GetClientRequest request) {
        getClientRequestLogger.setLogger(request);
        GetClientResponse response = getClientService.execute(request);
        getClientResponseLogger.setLogger(response);
        return response;
    }

    private UserRegistrationResponse processRequestRegistration(UserRegistrationRequest request) {
        requestLogger.setLogger(request);
        UserRegistrationResponse response = userRegistrationService.execute(request);
        responseLogger.setLogger(response);
        return response;
    }

}
