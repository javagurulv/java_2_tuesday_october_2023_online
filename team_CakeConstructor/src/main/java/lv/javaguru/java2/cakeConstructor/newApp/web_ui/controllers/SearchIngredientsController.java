package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchIngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchIngredientsController {

	@Autowired private SearchIngredientsService searchIngredientsService;


	@GetMapping(value = "/searchIngredients")
	public String showSearchIngredientsPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new SearchIngredientsRequest());
		return "searchIngredients";
	}

	@PostMapping("/searchIngredients")
	public String processSearchIngredientsRequest(@ModelAttribute(value = "request") SearchIngredientsRequest request, ModelMap modelMap) {
		SearchIngredientsResponse response = searchIngredientsService.execute(request);
		modelMap.addAttribute("ingredients", response.getIngredients());
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
		}
		return "searchIngredients";
	}

}
