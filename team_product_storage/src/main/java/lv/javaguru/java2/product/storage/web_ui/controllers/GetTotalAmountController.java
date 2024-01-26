package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.*;
import lv.javaguru.java2.product.storage.core.responses.GetTotalAmountResponse;
import lv.javaguru.java2.product.storage.core.services.GetTotalAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GetTotalAmountController {

	@Autowired private GetTotalAmountService getTotalAmountService;


	@GetMapping(value = "/getTotalAmount")
	public String showGetTotalAmountPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new GetTotalAmountRequest());
		return "getTotalAmount";
	}

	@PostMapping("/getTotalAmount")
	public String processGetTotalAmountRequest(@ModelAttribute(value = "request") GetTotalAmountRequest request, ModelMap modelMap) {
		GetTotalAmountResponse response = getTotalAmountService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "getTotalAmount";
		} else {
			return "redirect:/";
		}
	}


}
