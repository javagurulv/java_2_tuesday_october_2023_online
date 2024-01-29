package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.CreateOrderRequest;
import lv.javaguru.java2.product.storage.core.requests.SearchCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.CreateOrderResponse;
import lv.javaguru.java2.product.storage.core.responses.SearchCustomersResponse;
import lv.javaguru.java2.product.storage.core.services.CreateOrderService;
import lv.javaguru.java2.product.storage.core.services.SearchCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateOrderController {

	@Autowired private CreateOrderService createOrderService;
	@Autowired private SearchCustomersService searchCustomersService;


	@GetMapping(value = "/createOrder")
	public String showCreateOrderPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new CreateOrderRequest());
		modelMap.addAttribute("searchRequest", new SearchCustomersRequest());
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

	@PostMapping("/createOrder/search")
	public String processSearchCustomersRequest(@ModelAttribute(value = "searchRequest") SearchCustomersRequest searchRequest,
											  ModelMap modelMap) {
		SearchCustomersRequest searchCustomersRequest = new SearchCustomersRequest(
				searchRequest.getCustomerName(), searchRequest.getRegistrationCode()
		);
		SearchCustomersResponse searchCustomersResponse = searchCustomersService.execute(searchCustomersRequest);
		modelMap.addAttribute("customers", searchCustomersResponse.getCustomers());


		modelMap.addAttribute("request", new CreateOrderRequest());

		return "createOrder";
	}


}
