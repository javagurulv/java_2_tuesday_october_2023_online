package lv.avangardteen.web_ui.controllers;

import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.request.GetClientRequest;
import lv.avangardteen.core.responce.DeleteOrderResponse;
import lv.avangardteen.core.service.DeleteOrderService;
import lv.avangardteen.core.service.GetClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DeleteOrderController {

    @Autowired
    private DeleteOrderService service;

    @GetMapping(value = "/deleteOrder")
    public String showDeletePage(ModelMap modelMap) {
        modelMap.addAttribute("request", new DeleteOrderRequest());
        return "deleteOrder";
    }

    @PostMapping("/deleteOrder")
    public String processDeleteOrderRequest(@ModelAttribute(value = "request") DeleteOrderRequest request, ModelMap modelMap) {
        DeleteOrderResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "deleteOrder";
        } else {
            return "redirect:/";
        }
    }
}
