package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientToCakeRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.AddIngredientToCakeResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientToCakeService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchIngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddIngredientToCakeController {

	@Autowired private AddIngredientToCakeService addIngredientToCakeService;
	@Autowired private SearchIngredientsService searchIngredientsService;


	@GetMapping(value = "/addIngredientToCake")
	public String showAddIngredientToCakePage(ModelMap modelMap) {
		modelMap.addAttribute("request", new AddIngredientToCakeRequest());
		modelMap.addAttribute("searchRequest", new SearchIngredientsRequest());
		return "addIngredientToCake";
	}

	@PostMapping("/addIngredientToCake")
	public String processAddIngredientToCakeRequest(@ModelAttribute(value = "request") AddIngredientToCakeRequest request, ModelMap modelMap) {
		AddIngredientToCakeResponse response = addIngredientToCakeService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "addIngredientToCake";
		} else {
			return "redirect:/";
		}
	}

	@PostMapping("/addIngredientToCake/search")
	public String processSearchIngredientsRequest(@ModelAttribute(value = "searchRequest") SearchIngredientsRequest searchRequest,
											  ModelMap modelMap) {
		SearchIngredientsRequest searchIngredientsRequest = new SearchIngredientsRequest(
		searchRequest.getType(), searchRequest.getTaste()
		);
		SearchIngredientsResponse searchIngredientsResponse = searchIngredientsService.execute(searchIngredientsRequest);
		modelMap.addAttribute("ingredients", searchIngredientsResponse.getIngredients());


		modelMap.addAttribute("request", new AddIngredientToCakeRequest());

		return "addIngredientToCake";
	}


}
