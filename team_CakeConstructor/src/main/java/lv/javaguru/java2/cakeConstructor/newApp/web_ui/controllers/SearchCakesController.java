package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchCakesRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchCakesResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchCakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchCakesController {

	@Autowired private SearchCakesService searchCakesService;


	@GetMapping(value = "/searchCakes")
	public String showSearchCakesPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new SearchCakesRequest());
		return "searchCakes";
	}

	@PostMapping("/searchCakes")
	public String processSearchCakesRequest(@ModelAttribute(value = "request") SearchCakesRequest request, ModelMap modelMap) {
		SearchCakesResponse response = searchCakesService.execute(request);
		modelMap.addAttribute("cakes", response.getCakes());
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
		}
		return "searchCakes";
	}

}
