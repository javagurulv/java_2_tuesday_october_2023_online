package fitness_club.web_ui.controllers;

import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.responses.AddClientResponse;
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

    @GetMapping(value = "/addClientToList")
    public String showAddClientPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddClientRequest());
        return "addClientToList";
    }

    @PostMapping("/addClientToList")
    public String processAddClientRequest(@ModelAttribute(value = "request") AddClientRequest request, ModelMap modelMap) {
        AddClientResponse response = addClientService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "addClientToList";
        } else {
            return "index";
        }
    }
}
