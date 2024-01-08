package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.RegisterCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.RegisterCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.RegisterCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterCustomerController {

    @Autowired
    private RegisterCustomerService registerCustomerService;


    @GetMapping(value = "/registerCustomer")
    public String showRegisterCustomerPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new RegisterCustomerRequest());
        return "registerCustomer";
    }

    @PostMapping("/registerCustomer")
    public String processRegisterCustomerRequest(@ModelAttribute(value = "request") RegisterCustomerRequest request, ModelMap modelMap) {
        RegisterCustomerResponse response = registerCustomerService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "registerCustomer";
        } else {
            return "redirect:/";
        }
    }

}
