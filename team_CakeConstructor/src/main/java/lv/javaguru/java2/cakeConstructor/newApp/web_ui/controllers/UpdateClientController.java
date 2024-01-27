package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.UpdateClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.UpdateClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.UpdateClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateClientController {

	@Autowired private UpdateClientService updateClientService;


	@GetMapping(value = "/updateClient")
	public String showUpdateClientPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new UpdateClientRequest());
		return "updateClient";
	}

	@PostMapping("/updateClient")
	public String processUpdateClientRequest(@ModelAttribute(value = "request") UpdateClientRequest request, ModelMap modelMap) {
		UpdateClientResponse response = updateClientService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "updateClient";
		} else {
			return "redirect:/";
		}
	}

}
