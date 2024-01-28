package lv.avangardteen.web_ui.controllers;

import lv.avangardteen.core.request.GetClientRequest;
import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.responce.GetClientResponse;
import lv.avangardteen.core.responce.UserRegistrationResponse;
import lv.avangardteen.core.service.GetClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchClientController {

    @Autowired
    private GetClientService getClientService;

    @GetMapping(value = "/searchClient")
    public String showIdClient(ModelMap modelMap) {
        modelMap.addAttribute("request", new GetClientRequest());
        return "searchClient";
    }

    @PostMapping("/searchClient")
    public String processUserRegistrationRequest(@ModelAttribute(value = "request") GetClientRequest request, ModelMap modelMap) {
        GetClientResponse response = getClientService.execute(request);
        modelMap.addAttribute("clients", response.getClient());
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
        }
        return "searchClient";
    }
}
