package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.UpdateIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.UpdateIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.UpdateIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateIngredientController {

	@Autowired private UpdateIngredientService updateIngredientService;


	@GetMapping(value = "/updateIngredient")
	public String showUpdateIngredientPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new UpdateIngredientRequest());
		return "updateIngredient";
	}

	@PostMapping("/updateIngredient")
	public String processUpdateIngredientRequest(@ModelAttribute(value = "request") UpdateIngredientRequest request, ModelMap modelMap) {
		UpdateIngredientResponse response = updateIngredientService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "updateIngredient";
		} else {
			return "redirect:/";
		}
	}

}
