package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.CreateOrderRequest;
import lv.javaguru.java2.product.storage.core.responses.CreateOrderResponse;
import lv.javaguru.java2.product.storage.core.services.CreateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateOrderController {

	@Autowired private CreateOrderService createOrderService;


	@GetMapping(value = "/createOrder")
	public String showCreateOrderPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new CreateOrderRequest());
		return "createOrder";
	}

	@PostMapping("/createOrder")
	public String processCreateOrderRequest(@ModelAttribute(value = "request") CreateOrderRequest request, ModelMap modelMap) {
		CreateOrderResponse response = createOrderService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "createOrder";
		} else {
			return "redirect:/";
		}
	}


}
