package lv.avangardteen.web_ui.controllers;

import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.responce.UserRegistrationResponse;
import lv.avangardteen.core.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService service;


    @GetMapping(value = "/userRegistration")
    public String showUserRegistrationPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new UserRegistrationRequest());
        return "userRegistration";
    }

    @PostMapping("/userRegistration")
    public String processUserRegistrationRequest(@ModelAttribute(value = "request") UserRegistrationRequest request, ModelMap modelMap) {
        UserRegistrationResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "userRegistration";
        } else {
            return "redirect:/";
        }
    }

}
