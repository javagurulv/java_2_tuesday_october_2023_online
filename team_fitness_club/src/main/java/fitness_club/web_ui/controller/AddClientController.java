package fitness_club.web_ui.controller;

import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.services.AddClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddClientController {
    @Autowired
    private AddClientService addClientService;

    @GetMapping(value = "/addNewClient")
    public String showAddClientPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddClientRequest());
        return "addNewClient";
    }

    @PostMapping("/addNewClient")
    public String processAddClientRequest(@ModelAttribute(value = "request") AddClientRequest request) {
        addClientService.execute(request);
        return "index";
    }
}
