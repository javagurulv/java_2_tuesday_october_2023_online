package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.UpdateCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.UpdateCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateCustomerController {

	@Autowired private UpdateCustomerService updateCustomerService;


	@GetMapping(value = "/updateCustomer")
	public String showUpdateCustomerPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new UpdateCustomerRequest());
		return "updateCustomer";
	}

	@PostMapping("/updateCustomer")
	public String processUpdateCustomerRequest(@ModelAttribute(value = "request") UpdateCustomerRequest request, ModelMap modelMap) {
		UpdateCustomerResponse response = updateCustomerService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "updateCustomer";
		} else {
			return "redirect:/";
		}
	}

}
