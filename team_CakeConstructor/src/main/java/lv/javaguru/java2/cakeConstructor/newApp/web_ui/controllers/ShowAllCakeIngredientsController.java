package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllCakeIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllCakeIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllCakeIngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllCakeIngredientsController {

	@Autowired private GetAllCakeIngredientsService getAllCakeIngredientsService;


	@GetMapping(value = "/showAllCakeIngredients")
	public String showAllCakeIngredients(ModelMap modelMap) {
		GetAllCakeIngredientsResponse response = getAllCakeIngredientsService.execute(
				new GetAllCakeIngredientsRequest()
		);
		modelMap.addAttribute("cakeIngredients", response.getCakeIngredients());
		return "/showAllCakeIngredients";
	}

}
