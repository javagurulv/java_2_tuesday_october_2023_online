package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.DeleteClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.DeleteClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.DeleteClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteClientController {

	@Autowired private DeleteClientService deleteClientService;


	@GetMapping(value = "/deleteClient")
	public String showDeleteClientPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new DeleteClientRequest());
		return "deleteClient";
	}

	@PostMapping("/deleteClient")
	public String processDeleteClientRequest(@ModelAttribute(value = "request") DeleteClientRequest request, ModelMap modelMap) {
		DeleteClientResponse response = deleteClientService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "deleteClient";
		} else {
			return "redirect:/";
		}
	}

}
