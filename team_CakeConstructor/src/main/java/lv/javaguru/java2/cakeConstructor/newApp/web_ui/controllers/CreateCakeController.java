package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.CreateCakeRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CreateCakeResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.CreateCakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateCakeController {

	@Autowired private CreateCakeService createCakeService;


	@GetMapping(value = "/createCake")
	public String showCreateCakePage(ModelMap modelMap) {
		modelMap.addAttribute("request", new CreateCakeRequest());
		return "createCake";
	}

	@PostMapping("/createCake")
	public String processCreateCakeRequest(@ModelAttribute(value = "request") CreateCakeRequest request, ModelMap modelMap) {
		CreateCakeResponse response = createCakeService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "createCake";
		} else {
			return "redirect:/";
		}
	}

}
