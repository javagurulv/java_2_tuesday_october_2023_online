package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.SearchCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.SearchCustomersResponse;
import lv.javaguru.java2.product.storage.core.services.SearchCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchCustomersController {

	@Autowired private SearchCustomersService searchCustomersService;


	@GetMapping(value = "/searchCustomers")
	public String showSearchCustomersPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new SearchCustomersRequest());
		return "searchCustomers";
	}

	@PostMapping("/searchCustomers")
	public String processSearchCustomersRequest(@ModelAttribute(value = "request") SearchCustomersRequest request, ModelMap modelMap) {
		SearchCustomersResponse response = searchCustomersService.execute(request);
		modelMap.addAttribute("customers", response.getCustomers());
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
		}
		return "searchCustomers";
	}

}
