package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.GetAllCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllCustomersResponse;
import lv.javaguru.java2.product.storage.core.services.GetAllCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllCustomersController {

	@Autowired private GetAllCustomersService getAllCustomersService;


	@GetMapping(value = "/showAllCustomers")
	public String showAllCustomers(ModelMap modelMap) {
		GetAllCustomersResponse response = getAllCustomersService.execute(
				new GetAllCustomersRequest()
		);
		modelMap.addAttribute("customers", response.getCustomers());
		return "/showAllCustomers";
	}

}
