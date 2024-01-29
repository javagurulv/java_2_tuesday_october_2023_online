package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllCakesRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllCakesResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllCakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllCakesController {

	@Autowired private GetAllCakesService getAllCakesService;


	@GetMapping(value = "/showAllCakes")
	public String showAllCakes(ModelMap modelMap) {
		GetAllCakesResponse response = getAllCakesService.execute(
				new GetAllCakesRequest()
		);
		modelMap.addAttribute("cakes", response.getCakes());
		return "/showAllCakes";
	}

}
