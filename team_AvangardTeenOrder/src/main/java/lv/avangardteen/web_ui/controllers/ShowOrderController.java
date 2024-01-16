package lv.avangardteen.web_ui.controllers;

import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.ShowOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowOrderController {

    @Autowired
    private ShowOrderService service;


    @GetMapping(value = "/showOrder")
    public String showOrder(ModelMap modelMap) {
        ShowOrderResponse response = service.execute(
                new ShowOrderRequest()
        );
        modelMap.addAttribute("order", response.getWheelchair());
        modelMap.addAttribute("components", response.getWheelchairComponents());
        modelMap.addAttribute("price wheelchair", response.getPriceWheelchair());
        modelMap.addAttribute("price components", response.getWheelchairComponents());
        modelMap.addAttribute("price order", response.getPriceOrder());
        return "/showOrder";
    }
}
