package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllOrdersRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllOrdersResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllOrdersController {

	@Autowired private GetAllOrdersService getAllOrdersService;


	@GetMapping(value = "/showAllOrders")
	public String showAllOrders(ModelMap modelMap) {
		GetAllOrdersResponse response = getAllOrdersService.execute(
				new GetAllOrdersRequest()
		);
		modelMap.addAttribute("orders", response.getOrders());
		return "/showAllOrders";
	}

}
