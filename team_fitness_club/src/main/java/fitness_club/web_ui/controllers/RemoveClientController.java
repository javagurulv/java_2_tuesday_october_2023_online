package fitness_club.web_ui.controllers;

import fitness_club.core.requests.RemoveClientByIdRequest;
import fitness_club.core.responses.RemoveClientByIdResponse;
import fitness_club.core.services.RemoveClientByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RemoveClientController {

    @Autowired
    private RemoveClientByIdService deleteClientByIdService;

    @GetMapping(value = "/removeClientFromList")
    public String showRemoveClientPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new RemoveClientByIdRequest());
        return "removeClient";
    }

    @PostMapping("/removeClientFromList")
    public String processRemoveClientRequest(@ModelAttribute(value = "request") RemoveClientByIdRequest request, ModelMap modelMap) {
        RemoveClientByIdResponse response = deleteClientByIdService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "removeClient";
        } else {
            return "index";
        }
    }

}
