package fitness_club.web_ui.controllers;

import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.RemoveClientRequest;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.core.responses.RemoveClientResponse;
import fitness_club.core.services.RemoveClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RemoveClientController {

    @Autowired private RemoveClientService removeClientService;

    @GetMapping(value = "/removeClientFromList")
    public String showRemoveClientPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new RemoveClientRequest());
        return "removeClient";
    }
    @PostMapping("/removeClientFromList")
    public String processRemoveClientRequest(@ModelAttribute(value = "request") RemoveClientRequest request, ModelMap modelMap) {
        RemoveClientResponse response = removeClientService.execute(request) ;
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "removeClient";
        } else {
            return "index";
        }
    }

}
