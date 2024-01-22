package fitness_club.web_ui.controllers;

import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.responses.GetAllClientsResponse;
import fitness_club.core.services.GetAllClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllClientsController {

    @Autowired
    private GetAllClientsService getAllClientsService;

    @GetMapping (value = "/showAllClients")
    public String showAllClients(ModelMap modelMap) {
        GetAllClientsResponse response = getAllClientsService.execute(
                new GetAllClientsRequest()
        );
        modelMap.addAttribute("clients", response.getClients());
        return "/showAllClients";
    }


}
