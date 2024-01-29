package lv.avangardteen.web_ui.controllers;

import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.responce.UserRegistrationResponse;
import lv.avangardteen.core.service.ShowOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShowOrderController {

    @Autowired
    private ShowOrderService service;

    @GetMapping(value = "/showOrder")
    public String showUserRegistrationPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new ShowOrderRequest());
        return "showOrder";
    }

    @PostMapping(value = "/showOrder")
    public String showOrder(@ModelAttribute(value = "request") ShowOrderRequest request, ModelMap modelMap) {
        ShowOrderResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
        } else {
            modelMap.addAttribute("wheelchairs", response.getWheelchair());
            modelMap.addAttribute("componentList", response.getWheelchairComponents());
            modelMap.addAttribute("price", response.getPriceOrder());

        }
        return "showOrder";
    }


}
