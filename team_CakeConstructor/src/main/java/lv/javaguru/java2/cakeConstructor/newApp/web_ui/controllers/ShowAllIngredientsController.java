package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllIngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllIngredientsController {

	@Autowired private GetAllIngredientsService getAllIngredientsService;


	@GetMapping(value = "/showAllIngredients")
	public String showAllIngredients(ModelMap modelMap) {
		GetAllIngredientsResponse response = getAllIngredientsService.execute(
				new GetAllIngredientsRequest()
		);
		modelMap.addAttribute("ingredients", response.getIngredients());
		return "/showAllIngredients";
	}

}
