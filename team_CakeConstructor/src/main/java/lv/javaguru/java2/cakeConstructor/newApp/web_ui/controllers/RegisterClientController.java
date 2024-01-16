package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RegisterClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RegisterClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.RegisterClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterClientController {

    @Autowired
    private RegisterClientService registerClientService;


    @GetMapping(value = "/registerClient")
    public String showRegisterClientPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new RegisterClientRequest());
        return "registerClient";
    }

    @PostMapping("/registerClient")
    public String processRegisterClientRequest(@ModelAttribute(value = "request") RegisterClientRequest request, ModelMap modelMap) {
        RegisterClientResponse response = registerClientService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "registerClient";
        } else {
            return "redirect:/";
        }
    }

}
