package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.AddIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddIngredientController {

	@Autowired private AddIngredientService addIngredientService;


	@GetMapping(value = "/addIngredientToList")
	public String showAddIngredientPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new AddIngredientRequest());
		return "addIngredientToList";
	}

	@PostMapping("/addIngredientToList")
	public String processAddIngredientRequest(@ModelAttribute(value = "request") AddIngredientRequest request, ModelMap modelMap) {
		AddIngredientResponse response = addIngredientService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "addIngredientToList";
		} else {
			return "redirect:/";
		}
	}

}
