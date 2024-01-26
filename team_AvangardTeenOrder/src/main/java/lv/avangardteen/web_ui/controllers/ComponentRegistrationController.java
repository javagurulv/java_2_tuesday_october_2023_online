package lv.avangardteen.web_ui.controllers;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class ComponentRegistrationController {
    @GetMapping(value = "/componentRegistration")
    public String showIdClient(ModelMap modelMap){
        return "componentRegistration";
    }
}
