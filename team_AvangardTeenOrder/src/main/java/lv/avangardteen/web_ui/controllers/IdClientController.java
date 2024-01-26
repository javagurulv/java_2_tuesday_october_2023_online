package lv.avangardteen.web_ui.controllers;

import lv.avangardteen.core.responce.UserRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IdClientController {

    @GetMapping(value = "/userRegistration/idClient")
    public String showIdClient(ModelMap modelMap
    ) { modelMap.addAttribute("idNumber");
        return "idClient";
    }
}
