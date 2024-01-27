package lv.avangardteen.web_ui.controllers;

import lv.avangardteen.core.database.DataComponents;
import lv.avangardteen.core.domain.Components;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.responce.ComponentRegistrationResponse;
import lv.avangardteen.core.service.ComponentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class ComponentRegistrationController {
    @Autowired
    private DataComponents dataComponents;
    @Autowired
    private ComponentRegistrationService componentRegistrationService;

    @GetMapping(value = "/componentRegistration")
    public String showComponents(ModelMap modelMap) {
        List<Components> allFrontWheels = dataComponents.allFrontWheels();
        modelMap.addAttribute("allFrontWheels", allFrontWheels);

        List<Components> allFootrests = dataComponents.allFootrest();
        modelMap.addAttribute("allFootrests", allFootrests);

        List<Components> allBrakes = dataComponents.allBrakes();
        modelMap.addAttribute("allBrakes", allBrakes);

        List<Components> allBackWheels = dataComponents.allBackWheels();
        modelMap.addAttribute("allBackWheels", allBackWheels);

        modelMap.addAttribute("request", new ComponentRegistrationRequest());
        return "componentRegistration";
    }

    @PostMapping(value = "/componentRegistration")
    public String getListComponents(@ModelAttribute(value = "request") ComponentRegistrationRequest request,
                                       ModelMap modelMap) {
        ComponentRegistrationResponse response = componentRegistrationService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());

        }
        return "componentRegistration";


    }
}
