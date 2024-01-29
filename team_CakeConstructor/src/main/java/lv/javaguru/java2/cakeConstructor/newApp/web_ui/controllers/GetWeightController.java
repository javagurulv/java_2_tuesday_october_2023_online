package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetWeightRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetWeightResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GetWeightController {

	@Autowired private GetWeightService getWeightService;


	@GetMapping(value = "/getWeight")
	public String showGetWeightPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new GetWeightRequest());
		return "getWeight";
	}

	@PostMapping("/getWeight")
	public String processGetWeightRequest(@ModelAttribute(value = "request") GetWeightRequest request, ModelMap modelMap) {
		GetWeightResponse response = getWeightService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "getWeight";
		} else {
			return "redirect:/";
		}
	}


}
