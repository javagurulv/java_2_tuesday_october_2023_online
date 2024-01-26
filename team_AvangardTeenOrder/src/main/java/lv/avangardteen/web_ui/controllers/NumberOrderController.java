package lv.avangardteen.web_ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumberOrderController {

    @GetMapping(value = "/order/numberOrder")
    public String showIdClient(ModelMap modelMap) {
        return "numberOrder";
    }
}
