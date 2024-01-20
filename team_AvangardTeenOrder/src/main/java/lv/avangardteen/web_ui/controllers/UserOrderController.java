package lv.avangardteen.web_ui.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserOrderController {

    @GetMapping(value = "/showOrder/userOrder")
    public String showUserOrderPage() {
        return "userOrder";
    }
}
