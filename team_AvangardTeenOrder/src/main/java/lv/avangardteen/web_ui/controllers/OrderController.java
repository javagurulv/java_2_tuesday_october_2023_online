package lv.avangardteen.web_ui.controllers;

import lv.avangardteen.core.request.OrderRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.responce.OrderResponse;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.responce.UserRegistrationResponse;
import lv.avangardteen.core.service.OrderService;
import lv.avangardteen.core.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;


    @GetMapping(value = "/order")
    public String showOrderPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new OrderRequest());
        return "order";

    }

    @PostMapping("/order")
    public String processOrderRequest(@ModelAttribute(value = "request") OrderRequest request, ModelMap modelMap) {
        OrderResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "order";
        } else {
            modelMap.addAttribute("idOrder", response.getIdOrder());
            return "redirect:/order/numberOrder";
        }
    }

}
