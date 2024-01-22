package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.DeleteCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.DeleteCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.DeleteCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteCustomerController {

	@Autowired private DeleteCustomerService deleteCustomerService;


	@GetMapping(value = "/deleteCustomer")
	public String showDeleteCustomerPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new DeleteCustomerRequest());
		return "deleteCustomer";
	}

	@PostMapping("/deleteCustomer")
	public String processDeleteCustomerRequest(@ModelAttribute(value = "request") DeleteCustomerRequest request, ModelMap modelMap) {
		DeleteCustomerResponse response = deleteCustomerService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "deleteCustomer";
		} else {
			return "redirect:/";
		}
	}

}
