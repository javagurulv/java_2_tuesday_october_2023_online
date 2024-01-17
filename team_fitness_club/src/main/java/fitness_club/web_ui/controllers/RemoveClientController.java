package fitness_club.web_ui.controllers;

import fitness_club.core.requests.DeleteClientByIdRequest;
import fitness_club.core.responses.DeleteClientByIdResponse;
import fitness_club.core.services.DeleteClientByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RemoveClientController {

    @Autowired
    private DeleteClientByIdService removeClientService;

    @GetMapping(value = "/removeClientFromList")
    public String showRemoveClientPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new DeleteClientByIdRequest());
        return "removeClient";
    }

    @PostMapping("/removeClientFromList")
    public String processRemoveClientRequest(@ModelAttribute(value = "request") DeleteClientByIdRequest request, ModelMap modelMap) {
        DeleteClientByIdResponse response = removeClientService.executeByClientId(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "removeClient";
        } else {
            return "index";
        }
    }

}
