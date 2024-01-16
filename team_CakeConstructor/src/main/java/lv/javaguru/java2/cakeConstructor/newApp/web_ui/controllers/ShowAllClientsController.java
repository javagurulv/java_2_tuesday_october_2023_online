package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllClientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllClientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllClientsController {

	@Autowired private GetAllClientsService getAllClientsService;


	@GetMapping(value = "/showAllClients")
	public String showAllClients(ModelMap modelMap) {
		GetAllClientsResponse response = getAllClientsService.execute(
				new GetAllClientsRequest()
		);
		modelMap.addAttribute("clients", response.getClients());
		return "/showAllClients";
	}

}
