package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.GetAllOrderItemsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllOrderItemsResponse;
import lv.javaguru.java2.product.storage.core.services.GetAllOrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllOrderItemsController {

	@Autowired private GetAllOrderItemsService getAllOrderItemsService;


	@GetMapping(value = "/showAllOrderItems")
	public String showAllOrderItems(ModelMap modelMap) {
		GetAllOrderItemsResponse response = getAllOrderItemsService.execute(
				new GetAllOrderItemsRequest()
		);
		modelMap.addAttribute("orderItems", response.getOrderItems());
		return "/showAllOrderItems";
	}

}
