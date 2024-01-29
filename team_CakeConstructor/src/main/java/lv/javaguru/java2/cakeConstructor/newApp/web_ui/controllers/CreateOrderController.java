package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchCakesRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchClientsAndCakesRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchClientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchCakesResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchClientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchCakesService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchClientsService;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.CreateOrderRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CreateOrderResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.CreateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateOrderController {

	@Autowired private CreateOrderService createOrderService;
	@Autowired private SearchClientsService searchClientsService;
	@Autowired private SearchCakesService searchCakesService;


	@GetMapping(value = "/createOrder")
	public String showCreateOrderPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new CreateOrderRequest());
		modelMap.addAttribute("searchRequest", new SearchClientsAndCakesRequest());
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
	public String processSearchClientsRequest(@ModelAttribute(value = "searchRequest") SearchClientsAndCakesRequest searchRequest,
											  ModelMap modelMap) {
		SearchClientsRequest searchClientsRequest = new SearchClientsRequest(
				searchRequest.getFirstName(), searchRequest.getLastName()
		);
		SearchClientsResponse searchClientsResponse = searchClientsService.execute(searchClientsRequest);
		modelMap.addAttribute("clients", searchClientsResponse.getClients());

		SearchCakesRequest searchCakesRequest = new SearchCakesRequest(
				searchRequest.getCakeName(), searchRequest.getWeight()
		);
		SearchCakesResponse searchCakesResponse = searchCakesService.execute(searchCakesRequest);
		modelMap.addAttribute("cakes", searchCakesResponse.getCakes());

		modelMap.addAttribute("request", new CreateOrderRequest());

		return "createOrder";
	}


}
