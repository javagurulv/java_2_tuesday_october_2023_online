package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.DeleteIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.DeleteIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.DeleteIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteIngredientController {

	@Autowired private DeleteIngredientService deleteIngredientService;


	@GetMapping(value = "/deleteIngredientFromList")
	public String showDeleteIngredientPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new DeleteIngredientRequest());
		return "deleteIngredientFromList";
	}

	@PostMapping("/deleteIngredientFromList")
	public String processDeleteIngredientRequest(@ModelAttribute(value = "request") DeleteIngredientRequest request, ModelMap modelMap) {
		DeleteIngredientResponse response = deleteIngredientService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "deleteIngredientFromList";
		} else {
			return "redirect:/";
		}
	}

}
