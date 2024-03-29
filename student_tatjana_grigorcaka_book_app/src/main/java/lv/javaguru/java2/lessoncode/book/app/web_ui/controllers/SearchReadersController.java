package lv.javaguru.java2.lessoncode.book.app.web_ui.controllers;

import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchReadersRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchReadersResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.SearchReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchReadersController {

	@Autowired private SearchReadersService searchReadersService;


	@GetMapping(value = "/searchReaders")
	public String showSearchReadersPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new SearchReadersRequest());
		return "searchReaders";
	}

	@PostMapping("/searchReaders")
	public String processSearchReadersRequest(@ModelAttribute(value = "request") SearchReadersRequest request, ModelMap modelMap) {
		SearchReadersResponse response = searchReadersService.execute(request);
		modelMap.addAttribute("readers", response.getReaders());
		if (response.containsErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
		}
		return "searchReaders";
	}

}
